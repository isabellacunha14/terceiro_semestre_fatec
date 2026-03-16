create database labDB_fatec
use labDB_fatec

create table marca (codigo int not null identity(1,1),
                    marca varchar(20),
                    constraint pk_marca primary key (codigo))
select * from marca

insert into marca values ('Ford'),('Vw'),('Honda'),('BYD'),('Hyundai'),('Toyota'),('Jeep'),('Cherry'),('Fiat'),('GWM'),
                         ('Renault'),('Peugeot'),('Mercedes'),('BMW'),('Porsche'),('Audi')

create table veiculo (placa varchar(7) not null,
                      codigomarca int, modelo varchar(50),
                      cor varchar(15), anofabricacao int,
                      valorfipe float,
                      constraint pk_veiculo primary key (placa))

select * from veiculo

insert into veiculo values 
                           ('CDE9812',1,'Ka','Preto',2015,40000),
                           ('DMH1011',3,'KCivic','Prata',2020,80000)

alter table veiculo add constraint fk_veicul_marca
                    foreign key (codigomarca) references
                    marca (codigo)

alter table veiculo add motor varchar(10)

update veiculo set motor = 'Flex'

insert into veiculo values 
         ('CCA1011',4,'Gurgel','Cinza',2026,245000,'Água'),
         ('XWA9914',6,'Corolla','Branco',2025,120000,'Flex'),
         ('FMU4G99',16,'Cayenne','Branco',2024,1000000,'Flex'),
         ('HAU4468', 14, 'March', 'Preto',2022,90000, 'Flex'),
         ('OMT1711',15,'R8','Prata',2025,1750000,'Gasolina'),
         ('NXZ1920',2,'Saveiro','Preto',2011,37000, 'Flex'),
         ('DQP9833',15,'320i','Azul',2023,250000, 'Turbo'),
         ('FER3254',7,'911 Carrera 4S','Marrom',2025,860000,'Gasolina'),
         ('FBA1045',7,'Renegade','Preto',2026,140000,'Flex'),
         ('FGL7612',9,'Palio','Preto',2002,20000,'Gasolina'),
         ('EVK4471',16,'Panamera','Preto',2022,400000,'Flex'),
         ('EDZ1234',9,'500','Branco',2017,65000,'Flex'),
         ('BZG2775',15,'Celta','Azul',1998,25000, 'Gasolina'),
         ('EMI2811',9,'Grand Siena','Branco',2013,50000, 'Flex'),
         ('BWO9997',9,'Doblo','Prata',2007,27000,'Flex'),
         ('EMI8821',13,'Grand Siena','Branco',2013,245000,'Flex')
-- inserts gerado por IA
insert into veiculo values ('AAA1961',14,'Mercedes 220','Preto',1961,120000,'Gasolina');
insert into veiculo values ('BBB1962',15,'BMW 1500','Branco',1962,95000,'Gasolina');
insert into veiculo values ('CCC1963',11,'Chevrolet Impala','Azul',1963,180000,'Gasolina');
insert into veiculo values ('DDD1964',9,'Fiat 600','Verde',1964,60000,'Gasolina');
insert into veiculo values ('EEE1965',2,'VW Fusca','Cinza',1965,70000,'Gasolina');
insert into veiculo values ('FFF1966',1,'Ford Mustang','Vermelho',1966,250000,'Gasolina');
insert into veiculo values ('GGG1967',3,'Honda S800','Amarelo',1967,130000,'Gasolina');
insert into veiculo values ('HHH1968',12,'Renault R4','Branco',1968,80000,'Gasolina');
insert into veiculo values ('III1969',13,'Peugeot 204','Prata',1969,90000,'Gasolina');
insert into veiculo values ('JJJ1960',17,'Audi 60','Verde',1960,100000,'Gasolina');
insert into veiculo values ('KKK2024',4,'BYD Dolphin','Azul',2024,150000,'Elétrico');
insert into veiculo values ('LLL2025',5,'Hyundai Kona','Cinza',2025,170000,'Elétrico');
insert into veiculo values ('MMM2024',6,'Toyota Corolla Cross','Preto',2024,160000,'Híbrido');
insert into veiculo values ('NNN2025',7,'Jeep Commander','Branco',2025,210000,'Flex');
insert into veiculo values ('OOO2024',8,'Chery Arrizo 6','Prata',2024,120000,'Flex');
insert into veiculo values ('PPP2025',10,'GWM Tank 300','Verde',2025,230000,'Gasolina');
insert into veiculo values ('QQQ2024',16,'Porsche Taycan','Vermelho',2024,750000,'Elétrico');
insert into veiculo values ('RRR2025',15,'BMW iX','Branco',2025,500000,'Elétrico');
insert into veiculo values ('SSS2024',17,'Audi Q4 e-tron','Cinza',2024,320000,'Elétrico');
insert into veiculo values ('TTT2025',11,'Chevrolet Tracker','Azul',2025,140000,'Flex');

select * from veiculo

/* consultas
select os campos separados por virgula, formulas, sub-query
from tabelas relacionadas com join
where filtrar informações
order by ordernar campos
group by agrupamento de campos
*/

select m.marca, v.modelo, v.cor, v.placa
from marca m inner join veiculo v on m.codigo = v.codigomarca
where v.anofabricacao < 2010
order by v.modelo

select m.marca, v.modelo, v.cor, v.placa
from marca m full join veiculo v on m.codigo = v.codigomarca
where v.anofabricacao < 2010
order by v.modelo

select m.marca, count(v.placa)
from marca m inner join veiculo v on m.codigo = v.codigomarca
group by m.marca
order by m.marca

--ACABOU A REVISAO--

/* views - visoes

são componentes que permitem armazenamento de selects
dentro da estrutura do bd
sao tambem consideradas tabelas virtuais
*/

create view listaveiculos
as
    select v.placa, v.modelo, v.cor
    from veiculo v

---- fim da view

select *from listaveiculos

update  listaveiculos set cor = 'Amarelo' where placa='BWO9997'

select *from veiculo

insert into listaveiculos values ('AIA3812','Corsa','Azul')

create view qtd_veiculo_marca
as
    select m.marca, count(v.placa) as 'qtd'
    from marca m inner join veiculo v on m.codigo=v.codigomarca
    group by m.marca
--fim

select qtd
from qtd_veiculo_marca
where qtd<3

create view velhinhos
as
    select v.modelo, v.cor, m.marca, v.anofabricacao
    from marca m inner join veiculo v on m.codigo=v.codigomarca
    where v.anofabricacao < 2000
    
--fim

select marca, modelo, cor
from velhinhos
where anofabricacao <1970
order by anofabricacao

/* stored procedures - procedimentos
bloco de codigo com logica de programaçao
representando a regra de negocio da aplicacao x banco
aqui é possivel utilizar variaveis, if, laço, etc.
*/

create procedure listaveiculo1
    ---inserir parametros (se tiver)
    --variavel 
    @ano int
as 
    select modelo,cor
    from veiculo
    where anofabricacao > @ano
--fim

exec listaveiculo1 2021
execute listaveiculo1 2021


alter procedure listaveiculo1
   @ano int
   @marca varchar(10)
as 
    select modelo,cor
    from velhinhos
    where anofabricacao > @ano and marca = @marca


alter procedure listaveiculos2
    @valor int  -- parametros da procedure
as
    declare @qtd int -- declarar variavel interna
    set @qtd = 10 -- atribuir valor para variavel
    print ('valor atual ' + convert(varchar, @qtd))
    set @qtd = @valor * 10
    print ('valor final ' + convert(varchar,@qtd))
--fim

exec listaveiculos2 100

create procedure listaveiculo3
as
    declare @qtd int
    set @qtd = (select count(v.placa) from veiculo v)
    print('Qtd de veiculo encontrado ' + convert (varchar,@qtd))

exec listaveiculo3 80000

alter procedure listaveiculo3
    @valorveiculo float
as
    declare @qtd int
    set @qtd = (select count(v.placa) 
                from veiculo v
                where valorfipe < @valorveiculo)
    print(convert (varchar,@qtd) 
        + ' veiculos encontrados com valor (em reais) (R$) de até ' 
        + convert(varchar,@valorveiculo))

alter procedure listaveiculo3
    @valorveiculo float
as
    declare @qtd int
    set @qtd = (select count(v.placa) 
                from veiculo v
                where valorfipe < @valorveiculo)
    print(convert (varchar,@qtd) 
        + ' veiculos encontrados com valor (em reais) (R$) de até ' 
        + convert(varchar,@valorveiculo))

/* EXERCICIOS

1 - criar uma view para armazenar como relatório os veiculos
que possuem ano de fabricação superior a 2024 e cor prata. 
No resultado da view apresentar o modelo, marca, placa, cor e
ano de fabricação. 

2 - Criar uma procedure com um parametro marca que apresente
uma mensagem da quantidade de veículos encontrados no banco
com a marca que foi passada por parametro. 
*/

-- 1 exercicio
CREATE VIEW vw_veiculos_ano_cor AS
SELECT 
    v.modelo,
    m.marca,
    v.placa,
    v.cor,
    v.anofabricacao
FROM marca m  INNER JOIN veiculo v
    ON m.codigo = v.codigomarca
WHERE v.anofabricacao > 2024
  AND v.cor = 'Prata';
--fim

SELECT * FROM vw_veiculos_ano_cor;

-- 2 exercicio

CREATE PROCEDURE sp_qtd_veiculos_por_marca
    @marca VARCHAR(100)
AS
BEGIN
    DECLARE @quantidade INT;

    SELECT @quantidade = COUNT(v.placa)
    FROM dbo.veiculo v
    INNER JOIN dbo.marca m
        ON m.codigo = v.codigomarca
    WHERE m.marca = @marca;

    PRINT 'Quantidade de veículos encontrados: ' + CAST(@quantidade AS VARCHAR);
END;

--fim

EXEC sp_qtd_veiculos_por_marca 'Fiat'; --exemplo


----- AULA 27/02 ----

--alterações no exercicio
ALTER PROCEDURE sp_qtd_veiculos_por_marca
    @marca VARCHAR(100), @ano int
AS
BEGIN
    DECLARE @quantidade INT;

    SELECT @quantidade = COUNT(v.placa)
    FROM dbo.veiculo v
    INNER JOIN dbo.marca m
        ON m.codigo = v.codigomarca
    WHERE m.marca = @marca;

    PRINT 'Quantidade de veículos encontrados: ' + CAST(@quantidade AS VARCHAR);

    DECLARE @qtdano int --new
    set @qtdano = (select count(v.placa)
                    from marca m inner join veiculo v 
                        ON m.codigo = v.codigomarca
                    where anofabricacao = @ano)
    print ('Encontrado ' + convert(varchar, @qtdano) + ' veiculos do ano ' + convert(varchar,@ano))

END;

exec sp_qtd_veiculos_por_marca 'fiat', 2000

--alterações no exercicio
ALTER PROCEDURE sp_qtd_veiculos_por_marca
    @marca VARCHAR(100), @ano int
AS
BEGIN
    DECLARE @qt INT;
    set @qt = (select count(v.placa)
                from marca m inner join veiculo v on m.codigo=v.codigomarca
                where m.marca = @marca)
print ('Encontrado ' + convert(varchar, @qt) + ' veiculos da marca ' + @marca)

 set @qt = (select count (v.placa)
            from veiculo v 
            where v.anofabricacao = @ano)
print ('Encontrado ' + convert(varchar, @qt) + ' veiculos do ano ' + convert(varchar,@ano))

set @qt = (select count(v.placa)
            from marca m inner join veiculo v
            on m.codigo=v.codigomarca
            where m.marca = @marca and v.anofabricacao = @ano)
print ('Encontrado ' + convert(varchar,@qt) + ' veiculos da marca ' 
+ @marca + ' e do ano ' + convert(varchar,@ano) )

END;

exec sp_qtd_veiculos_por_marca 'fiat', 1964

---nova

create procedure decisao
@ano float
as
    declare @media float
    declare @qtd int
    set @media = (select avg(valorfipe)
                   from veiculo   
                   where anofabricacao < @ano)
    if @media = null
        print('O valor da media zerou')
    else
        print ('Média do valor dos veiculos inferior a ' 
                + convert(varchar, @ano)
                + ' é ' 
                + convert(varchar, convert(numeric(10,2),@media)))


alter procedure decisao
@ano float
as
    declare @media float
    declare @qtd int
    set @media = (select avg(valorfipe)
                   from veiculo   
                   where anofabricacao < @ano)
    if @media is null
        print('O valor da media zerou, não encontrei veiculos inferior a ' + convert(varchar,@ano))
    else
        print ('Média do valor dos veiculos inferior a ' 
                + convert(varchar, @ano)
                + ' é ' 
                + convert(varchar, convert(numeric(10,2),@media)))


exec decisao 202012

--new2

alter procedure antigonovo
@opcao varchar(1)
as
    declare @inf varchar(200) = ''
    declare @valor int
    
    if @opcao = 'V' or @opcao = 'v'
       begin
            set @valor = (select min(anofabricacao) from veiculo)
            set @inf = @inf + 'O veiculo mais antigo tem ' + convert(varchar,@valor) + ' anos'
    end else begin
           if @opcao = 'n' or @opcao = 'N'
           begin
            set @valor = (select max(anofabricacao) from veiculo)
            set @inf = @inf + 'O veiculo mais antigo tem ' + convert(varchar,@valor) + ' anos'
            end else begin
            print('Parametro opcao incorreto')
            end
     end

    print(@inf)

    exec antigonovo v

    /* EXERCICIO - Criar uma procedure para simular uma calculadora
            A procedure deve receber 3 parametros, Operacao, valor 1 e valor 2
            As operacoes (+ - * / ) deve calcular e apresentar o valor com print

    */

ALTER PROCEDURE calculadora
    @operacao VARCHAR(1),
    @valor1 FLOAT,
    @valor2 FLOAT
AS
BEGIN
    DECLARE @resultado FLOAT;

    
    IF @operacao = '+'  -- operação de soma
        SET @resultado = @valor1 + @valor2;
    ELSE IF @operacao = '-' -- operação de diferença
               SET @resultado = @valor1 - @valor2
    ELSE IF @operacao = '*' --operação de multiplicação
                SET @resultado = @valor1 * @valor2
    ELSE IF @operacao = '/' --operação de divisao
            BEGIN
                if @valor2 = 0
                    print ('Nao é possivel dividir por 0')
                SET @resultado = @valor1 / @valor2
            END
  
    PRINT 'Resultado: ' + convert(varchar, @resultado);
END

exec calculadora '/',10,4

--- aula 06/03

create table log (sequencia int not null identity(1,1), momento datetime, 
                  ocorrencia varchar(255))

select * from log

-- procedure para pesquisar uma marca no banco. se encontrar a marca, apresentar 
--a qtd de veiculos cadastrados nessa marca, senão cadastrar a marca na tabela. 
create procedure validamarca 
 @marca varchar(20)
as
 declare @codigo int = 0
 --set @codigo = (select codigo from marca where marca = @marca)
 select @codigo = codigo from marca where marca = @marca
 if @codigo = 0 
 begin
    print ('Marca não cadastrada no banco de dados. Cadastrando a marca...')
	insert into marca values (@marca)
	print ('marca cadastrada com sucesso...')
	insert into log (momento, ocorrencia) values (getdate(),'Cadastrado a marca '+@marca)
 end else begin
    declare @qtd int = 0
	select @qtd = count(v.placa) from marca m inner join veiculo v 
	              on m.codigo = v.codigomarca where m.marca = @marca
    print ('Encontrado '+convert(varchar,@qtd) +' veiculos da marca '+ @marca)
	insert into log values (getdate(),'Encontrado '+convert(varchar,@qtd) +' veiculos da marca '+ @marca)
 end

 exec validamarca 'Gurgel'
 select * from log

 create table proprietario (codigo int not null identity(100,1), 
                      nome varchar(50), idade int, cidade varchar(50),
					  sexo varchar(1), 
					  constraint pk_proprietario primary key (codigo))

insert into proprietario values ('Pedro',19,'São paulo','M'),
                                ('Maria',20,'Mogi Mirim','F'),
								('Juan',34,'Guaçu','M'),
								('Joao',54,'Campinas','M'),
								('Thiago',31,'Mogi Mirim','M'),
								('Adriana',29,'Estiva','F'),
								('Andre',51,'Campinas','M')

select * from proprietario

alter table veiculo add proprietario int, constraint fk_pro_veic foreign key
                             (proprietario) references proprietario (codigo)

select * from veiculo 


/* exercicio
ao executar uma procedure cadastro_veiculo o usuário devera passar como parametro
os campos:

exec cadastro_Veiculo 'AAA0000','Wv','Fusca','Preto',1969,40000,'Gasolina','Adriana'

3 problemas?
- se passar a placa vazio.
- existe a marca? e se não existir?
- existe o proprietario? e se não existir?
*/

-- aula 13/03

update veiculo set proprietario = 101 where placa in ('AAA1961','AIA3812')
update veiculo set proprietario = 103 where placa in ('BBB1962','BWO9997','BZG2775',
                                                      'CCCA1011','CCC1963','CDE9812','DDD1964')
update veiculo set proprietario = 102 where placa in ('DQP9833','DWH1011','EDZ1234','EEE1965',
                                                       'EMI2811','EVK4471','FBA1045','FER3254','FFF1966')
update veiculo set proprietario = 106 where placa in ('FGL7612','FMU4G99')
update veiculo set proprietario = 104 where placa in ('GGG1967','HAU4468','HHH1968','III1969','JJJ1960','KKK2024',
                                                       'LLL2025','MMM2026','NNN2153','NXO1920','OMT1711','OOO2013',
                                                       'PPP2026', 'QQQ1997')

alter procedure cadastra_veiculo
@placa varchar(7),
@marca varchar(10),
@modelo varchar(30),
@cor varchar (30),
@ano int,
@valor float,
@motor varchar (15),
@proprietario varchar(50)
as
    if @placa != '' 
    begin
        declare @existemarca int = 0, @existepropr int = 0
        set @existemarca = (select count(codigo) from marca where marca = @marca)
        set @existepropr = (select count(codigo) from proprietario where nome = @proprietario)
        if @existemarca = 0 
        begin
            insert into marca values (@marca)
            print('Cadastrado a nova marca,' +@marca)
        end
        declare @codigomarca int
        set @codigomarca = (select codigo from marca where marca = @marca)
        if @existepropr = 0
        begin 
            insert into proprietario (nome) values (@proprietario)       
            print ('Cadastrado proprietario, preencher o restante dos dados')
        end   
        declare @codigopr int
        set @codigopr = (select codigo from proprietario where nome = @proprietario)
       insert into veiculo (placa,codigomarca,modelo,cor,anofabricacao,valor,motor,proprietario)    values
        (@placa,@codigomarca,@modelo,@cor,@ano,@valor,@motor,@codigopr)
        insert into log values (getdate(),'Cadastrado novo veiculo' +@modelo)
    end else begin
        print ('Placa invalida')
    end

-- fim da procedure

exec cadastra_veiculo 'AAA1113','FU','Calc','Branco',2010,140000,'Eletrico','IsabellaC'

select *from veiculo

-- procedure para consulta dinamica
  
alter procedure consulta_dinamica
    @modelo varchar (20), 
    @ano int, 
    @cor varchar (10)
as
    declare @sql varchar (500)
    set @sql = 'select placa, modelo, cor, anofabricacao'
    set @sql = @sql + ' from veiculo'
    set @sql = @sql + ' where 1=1'
   if @modelo is not null
    set @sql = @sql + ' and modelo = ''' + @modelo + ''''
   if @ano is not null
    set @sql = @sql + 'and anofabricacao = '+convert(varchar, @ano)
   if @cor is not null
    set @sql = @sql + 'and cor= '''+@cor+''''
    -- print (@sql)
   exec (@sql)
--- fim

exec consulta_dinamica 'civic',2000,null

--- exercicio
-- criar uma procedure para deletar um proprietario do banco de daods
-- ao deletar, observar se existe algum veiculo cadastrado para ele
-- se tiver, avisar por mensagem a qtd de veiculos que foi excluida
-- para depois excluir o proprietario
-- antes de excluir o proprietario verificar se ele existe
-- para executar a procedure utilizar exec excluir proprietario "fulano"

create procedure excluir_proprietario
    @nome varchar(50)
as
begin

    -- verificar se o proprietario existe
    declare @codigo int
    select @codigo = codigo from proprietario where nome = @nome

    if @codigo is null
    begin
        print('Proprietario não encontrado no banco de dados')
        return
    end

    -- verificar se existem veiculos
    declare @qtd int
    select @qtd = count(*) from veiculo where proprietario = @codigo

    if @qtd > 0
    begin
        print('Foram encontrados ' + convert(varchar,@qtd) + ' veiculos cadastrados para ' + @nome)

        -- excluir os veiculos
        delete from veiculo
        where proprietario = @codigo

        print('Veiculos excluidos com sucesso')
    end

    -- excluir o proprietario
    delete from proprietario
    where codigo = @codigo

    print('Proprietario excluido com sucesso')

end
