--LISANDRA COSTA E ISABELLA CUNHA

CREATE DATABASE LojaVestuario;
GO

USE LojaVestuario;
GO

CREATE TABLE Categoria (
    id_categoria  INT IDENTITY(1,1) PRIMARY KEY,
    nome          VARCHAR(50)   NOT NULL,
    descricao     VARCHAR(100)  NULL
);
GO

INSERT INTO Categoria (nome, descricao) VALUES
    ('Camisetas','Camisetas masculinas e femininas'),
    ('Calcas','Calcas jeans, leggins e cargo'),
    ('Vestidos','Vestidos casuais e sociais'),
    ('Acessorios','Cintos, bonés e cachecóis');
GO

CREATE TABLE Produto (
    id_produto    INT             IDENTITY(1,1) PRIMARY KEY,
    nome          VARCHAR(100)    NOT NULL,
    tamanho       VARCHAR(5)      NOT NULL, --PP, P, M, G, GG
    preco         DECIMAL(10,2)   NOT NULL,
    id_categoria  INT   NOT NULL,
    ativo         BIT   NOT NULL DEFAULT 1,
    CONSTRAINT FK_Produto_Categoria FOREIGN KEY (id_categoria)
        REFERENCES Categoria(id_categoria)
);
GO

INSERT INTO Produto (nome, tamanho, preco, id_categoria) VALUES
    ('Camiseta Básica Branca', 'M',  49.90,  1),
    ('Camiseta Estampada','G',  69.90,  1),
    ('Calca Jeans Slim','42', 149.90, 2),
    ('Vestido Floral','P',  119.90, 3),
    ('Cinto de Couro','Unico',  59.90,  4);
GO

CREATE TABLE Estoque (
    id_estoque    INT   IDENTITY(1,1) PRIMARY KEY,
    id_produto    INT   NOT NULL,
    quantidade    INT   NOT NULL DEFAULT 0,
    CONSTRAINT FK_Estoque_Produto FOREIGN KEY (id_produto)
        REFERENCES Produto(id_produto)
);
GO

INSERT INTO Estoque (id_produto, quantidade) VALUES
    (1, 13), (2, 21), (3, 12), (4, 5);
GO

CREATE TABLE Venda (
    id_venda      INT           IDENTITY(1,1) PRIMARY KEY,
    data_venda    DATETIME      NOT NULL DEFAULT GETDATE(),
    valor_total   DECIMAL(10,2) NOT NULL DEFAULT 0,
    forma_pagto   VARCHAR(20)   NOT NULL  -- DINHEIRO, CARTAO, PIX
);
GO

CREATE TABLE ItemVenda (
    id_item       INT   IDENTITY(1,1) PRIMARY KEY,
    id_venda      INT  NOT NULL,
    id_produto    INT  NOT NULL,
    quantidade    INT  NOT NULL,
    preco_unit    DECIMAL(10,2)   NOT NULL,
    CONSTRAINT FK_Item_Venda    FOREIGN KEY (id_venda)    REFERENCES Venda(id_venda),
    CONSTRAINT FK_Item_Produto  FOREIGN KEY (id_produto)  REFERENCES Produto(id_produto)
);
GO

CREATE TABLE LogProduto (
    id_log     INT           IDENTITY(1,1) PRIMARY KEY,
    data_hora  DATETIME      NOT NULL DEFAULT GETDATE(),
    operacao   VARCHAR(10)   NOT NULL,  -- INSERT ou UPDATE
    descricao  VARCHAR(255)  NOT NULL
);
GO

CREATE TABLE ProjecaoVendas (
    seq INT  IDENTITY(1,1) PRIMARY KEY,
    ano INT NOT NULL,
    mes INT NOT NULL,
    valor DECIMAL(10,2) NOT NULL
);
GO

CREATE OR ALTER PROCEDURE sp_CadastraProduto
    @nome         VARCHAR(100),
    @tamanho      VARCHAR(5),
    @preco        DECIMAL(10,2),
    @id_categoria INT
AS
BEGIN
    SET NOCOUNT ON;
 
    IF LTRIM(RTRIM(@nome)) = ''
    BEGIN
        PRINT 'ERRO: O parametro NOME nao pode ser vazio.';
        RETURN;
    END
 
   
    IF @tamanho NOT IN ('PP','P','M','G','GG','36','38','40','42','44','46','48','U')
    BEGIN
        PRINT 'ERRO: O TAMANHO e invalido. Use PP, P, M, G, GG, 36-48 ou U.';
        RETURN;
    END
 
    
    IF @preco <= 0
    BEGIN
        PRINT 'ERRO: O PRECO deve ser maior que zero.';
        RETURN;
    END
 
    IF NOT EXISTS (SELECT 1 FROM Categoria WHERE id_categoria = @id_categoria)
    BEGIN
        PRINT 'ERRO: O ID_CATEGORIA informado nao existe no cadastro.';
        RETURN;
    END
 
    INSERT INTO Produto (nome, tamanho, preco, id_categoria)
    VALUES (@nome, @tamanho, @preco, @id_categoria);
 
 
    DECLARE @novo_id INT = SCOPE_IDENTITY();
    INSERT INTO Estoque (id_produto, quantidade) VALUES (@novo_id, 0);
 
    PRINT 'Produto cadastrado com sucesso! ID: ' + CAST(@novo_id AS VARCHAR);
END;
GO

 EXEC sp_CadastraProduto 'Blusa Listrada', 'G', 89.90, 1;

 EXEC sp_CadastraProduto 'Blusa', 'G', -10, 1;

 EXEC sp_CadastraProduto 'Blusa', 'G', 89.90, 99;

 CREATE OR ALTER PROCEDURE sp_ProjetaVendas
    @mes_atual INT,
    @ano_atual INT
AS
BEGIN
    SET NOCOUNT ON;
 
  
    DECLARE @valor_base DECIMAL(10,2);
 
    SELECT @valor_base = ISNULL(SUM(valor_total), 1000.00)
    FROM Venda
    WHERE MONTH(data_venda) = @mes_atual
      AND YEAR(data_venda)  = @ano_atual;
 
    
    IF @valor_base = 0
        SET @valor_base = 1000.00;
 
   
    DELETE FROM ProjecaoVendas;
 
   
    DECLARE @contador   INT  = 1;
    DECLARE @mes_proj   INT  = @mes_atual;
    DECLARE @ano_proj   INT  = @ano_atual;
    DECLARE @valor_proj DECIMAL(10,2) = @valor_base;
 
  
    DECLARE @taxa DECIMAL(5,4) = 1.03;
 
    WHILE @contador <= 12
    BEGIN
       
        SET @mes_proj = @mes_proj + 1;
        IF @mes_proj > 12
        BEGIN
            SET @mes_proj = 1;
            SET @ano_proj = @ano_proj + 1;
        END
 
      
        SET @valor_proj = @valor_proj * @taxa;
 
        INSERT INTO ProjecaoVendas (ano, mes, valor)
        VALUES (@ano_proj, @mes_proj, ROUND(@valor_proj, 2));
 
        SET @contador = @contador + 1;
    END
 
    PRINT 'Projecao de 12 meses gerada com sucesso a partir de '
          + CAST(@mes_atual AS VARCHAR) + '/' + CAST(@ano_atual AS VARCHAR);
 
  
    SELECT ano, mes, valor FROM ProjecaoVendas ORDER BY ano, mes;
END;
GO
 
EXEC sp_ProjetaVendas 5, 2026;
 
 
 
CREATE OR ALTER TRIGGER trg_LogProduto
ON Produto
AFTER INSERT, UPDATE
AS
BEGIN
    SET NOCOUNT ON;
 
  
    IF EXISTS (SELECT 1 FROM DELETED)
    BEGIN
        INSERT INTO LogProduto (operacao, descricao)
        SELECT
            'UPDATE',
            'Produto ID ' + CAST(i.id_produto AS VARCHAR)
            + ' | Nome: ' + i.nome
            + ' | Preco antigo: R$ ' + CAST(d.preco AS VARCHAR)
            + ' -> Novo: R$ ' + CAST(i.preco AS VARCHAR)
        FROM INSERTED i
        JOIN DELETED d ON i.id_produto = d.id_produto;
    END
    ELSE
    BEGIN
     
        INSERT INTO LogProduto (operacao, descricao)
        SELECT
            'INSERT',
            'Produto ID ' + CAST(id_produto AS VARCHAR)
            + ' cadastrado: ' + nome
            + ' | Tamanho: ' + tamanho
            + ' | Preco: R$ ' + CAST(preco AS VARCHAR)
        FROM INSERTED;
    END
END;
GO

INSERT INTO Produto (nome, tamanho, preco, id_categoria) VALUES ('Jaqueta Jeans','G',299.90,2);
UPDATE Produto SET preco = 279.90 WHERE nome = 'Jaqueta Jeans';
SELECT * FROM LogProduto;
 
 
 
CREATE OR ALTER TRIGGER trg_AtualizaEstoque
ON ItemVenda
AFTER INSERT, UPDATE
AS
BEGIN
    SET NOCOUNT ON;
 
    IF EXISTS (SELECT 1 FROM DELETED)
    BEGIN
        UPDATE e
        SET e.quantidade = e.quantidade
                           - (i.quantidade - d.quantidade)
        FROM Estoque e
        JOIN INSERTED i ON e.id_produto = i.id_produto
        JOIN DELETED  d ON d.id_item    = i.id_item;
    END
    ELSE
    BEGIN
    
        UPDATE e
        SET e.quantidade = e.quantidade - i.quantidade
        FROM Estoque e
        JOIN INSERTED i ON e.id_produto = i.id_produto;
    END
END;
GO
 
UPDATE Estoque SET quantidade = 50 WHERE id_produto = 1;
UPDATE Estoque SET quantidade = 30 WHERE id_produto = 3;

INSERT INTO Venda (forma_pagto, valor_total) VALUES ('PIX', 249.80);

INSERT INTO ItemVenda (id_venda, id_produto, quantidade, preco_unit) VALUES (1, 1, 2, 49.90);

INSERT INTO ItemVenda (id_venda, id_produto, quantidade, preco_unit) VALUES (1, 3, 1, 149.90);

SELECT p.nome, e.quantidade FROM Estoque e JOIN Produto p ON p.id_produto = e.id_produto;
 