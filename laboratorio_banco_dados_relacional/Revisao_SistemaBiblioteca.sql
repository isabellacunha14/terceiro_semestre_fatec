CREATE DATABASE	SistemaBiblioteca

USE SistemaBiblioteca

--PARTE 1 Criacao de tabelas

-- Tabela 1

CREATE TABLE autor (codigo int not null identity(1,1),
					nome varchar (50),
					pais varchar (10),
					constraint pk_autor primary key (codigo))

CREATE TABLE livro (
    id int not null identity(1,1),
    titulo varchar(50),
    genero varchar(20),
    preco float,
    codigoautor int,
    constraint pk_livro primary key (id),
    constraint fk_livro_autor foreign key (codigoautor) references autor(codigo)
);

--PARTE 2 INSERCAO DE DADOS

INSERT INTO autor(nome, pais) values ('Maria','Brasil'),
									('John','Inglaterra'),
									('David', 'Alemanha'),
									('Carol','EUA'),
									('Isabella','Brasil')

select *from autor

-- Maria (codigoautor = 1)
INSERT INTO livro (titulo, genero, preco, codigoautor) VALUES
('Flores do Campo', 'Romance', 45.90, 1),
('Segredos da Serra', 'Drama', 52.00, 1),
('Caminhos da Vida', 'Biografia', 39.50, 1),
('O Jardim Esquecido', 'Romance', 49.90, 1),
('Entre Montanhas', 'Aventura', 55.00, 1);

-- John (codigoautor = 2)
INSERT INTO livro (titulo, genero, preco, codigoautor) VALUES
('The Silent River', 'Ficção', 60.00, 2),
('London Nights', 'Romance', 55.50, 2),
('Shadows of Time', 'Suspense', 62.30, 2),
('Echoes of Winter', 'Drama', 58.90, 2),
('The Last Kingdom', 'Aventura', 64.20, 2);

-- David (codigoautor = 3)
INSERT INTO livro (titulo, genero, preco, codigoautor) VALUES
('Berlin Stories', 'História', 70.00, 3),
('The Iron Wall', 'Ficção Científica', 65.40, 3),
('Dreams of Tomorrow', 'Fantasia', 58.20, 3),
('Voices of Europe', 'História', 72.50, 3),
('The Crystal Tower', 'Fantasia', 61.80, 3);

-- Carol (codigoautor = 4)
INSERT INTO livro (titulo, genero, preco, codigoautor) VALUES
('Freedom Road', 'Romance', 50.00, 4),
('American Tales', 'Contos', 47.80, 4),
('Stars Above', 'Ficção Científica', 63.00, 4),
('Golden Skies', 'Romance', 54.40, 4),
('Voices of Liberty', 'Drama', 59.90, 4);

-- Isabella (codigoautor = 5)
INSERT INTO livro (titulo, genero, preco, codigoautor) VALUES
('Coração Brasileiro', 'Romance', 44.90, 5),
('Lendas da Floresta', 'Fantasia', 59.00, 5),
('Histórias de Família', 'Drama', 48.50, 5),
('O Segredo das Águas', 'Suspense', 53.70, 5),
('Caminho das Estrelas', 'Ficção Científica', 62.10, 5);

select *from livro

-- PARTE 3 SELECT + WHERE + ORDER BY

select * from livro l
where l.preco > 50
order by l.preco

-- PARTE 4 JOIN

select l.titulo,a.nome as autor
from livro l
inner join autor a on a.codigo = l.codigoautor

-- PARTE 5 GROUP BY + FUNCOES

select a.nome, count(l.titulo) as qtde
from livro l
inner join autor a on a.codigo = l.codigoautor
group by a.nome

select a.nome, avg(l.preco) as media
from livro l
inner join autor a on a.codigo = l.codigoautor
group by a.nome

-- PARTE 6 VIEW

alter view livros_caros as
select  l.titulo, a.nome as autor, l.preco
from livro l
inner join autor a on a.codigo = l.codigoautor
where l.preco > 60 -- alterei para 60 para ter mais resultado

select * from livros_caros

-- PARTE 7 PROCEDURE

create procedure valor_livro
@valor float
as
select  l.titulo, l.preco
from livro l
where l.preco > @valor

exec valor_livro 40

--PARTE 8 PROCEDURE COM IF

create procedure qtd_livros
as
begin
	declare @qtd int

	select @qtd = count(l.titulo)
	from livro l 

	if @qtd >5
		print('Muitos Livros')
	else
		print('Poucos Livros')
end

exec qtd_livros

-- PARTE 9 WHILE 

declare @n int = 1

while (@n <= 5)
begin 
	print ('Valor: ' + convert(varchar, @n))
	set @n = @n + 1
end

-- PARTE 10 DESAFIO FINAL

create procedure qtd_autor
@nome varchar(50)
as
begin 
	declare @qtde int

	select @qtde = count(*) 
	from livro l
	inner join autor a on a.codigo = l.codigoautor
	where a.nome = @nome

	if @qtde > 0
		print('Autor: ' + @nome + ' Quantidade: ' + convert(varchar, @qtde))
	else
		print ('Autor nao encontrado')
end

exec qtd_autor 'Isabella'
exec qtd_autor 'Joana'