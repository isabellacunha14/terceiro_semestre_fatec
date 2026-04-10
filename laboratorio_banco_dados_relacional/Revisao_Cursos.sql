-- PARTE 1

CREATE DATABASE CursosOnline

USE CursosOnline

create table instrutor (codigo int not null identity (1,1),
						nome varchar(50),
						especialidade varchar(20),
						constraint pk_instrutor primary key (codigo))

create table curso (id int not null identity (1,1),
					titulo varchar(20),
					categoria varchar(20),
					preco float,
					codigoinstrutor int,
					constraint pk_curso primary key (id),
					constraint fk_curso_instrutor foreign key(codigoinstrutor) references instrutor(codigo))

-- PARTE 2

INSERT INTO instrutor (nome, especialidade) VALUES
('Carlos Silva', 'Programação'),
('Mariana Souza', 'Design'),
('João Pereira', 'Marketing'),
('Ana Costa', 'Finanças'),
('Roberto Lima', 'Fotografia');

-- Inserindo 25 Cursos (5 para cada instrutor)
-- Instrutor 1: Carlos Silva
INSERT INTO curso (titulo, categoria, preco, codigoinstrutor) VALUES
('Java Básico', 'Programação', 199.90, 1),
('Python Avançado', 'Programação', 299.90, 1),
('C# Essencial', 'Programação', 249.90, 1),
('Banco de Dados SQL', 'Programação', 229.90, 1),
('Desenvolvimento Web', 'Programação', 279.90, 1);

-- Instrutor 2: Mariana Souza
INSERT INTO curso (titulo, categoria, preco, codigoinstrutor) VALUES
('Photoshop Essencial', 'Design', 149.90, 2),
('Illustrator Criativo', 'Design', 179.90, 2),
('Design UX/UI', 'Design', 199.90, 2),
('CorelDRAW Avançado', 'Design', 159.90, 2),
('Design de Logotipos', 'Design', 189.90, 2);

-- Instrutor 3: João Pereira
INSERT INTO curso (titulo, categoria, preco, codigoinstrutor) VALUES
('Marketing Digital', 'Marketing', 249.90, 3),
('SEO Estratégico', 'Marketing', 199.90, 3),
('Gestão de Mídias Sociais', 'Marketing', 229.90, 3),
('Copywriting Persuasivo', 'Marketing', 179.90, 3),
('Google Ads Avançado', 'Marketing', 259.90, 3);

-- Instrutor 4: Ana Costa
INSERT INTO curso (titulo, categoria, preco, codigoinstrutor) VALUES
('Finanças Pessoais', 'Finanças', 129.90, 4),
('Investimentos ', 'Finanças', 199.90, 4),
('Contabilidade Básica', 'Finanças', 159.90, 4),
('Planejamento Fin', 'Finanças', 189.90, 4),
('Gestão de Custos', 'Finanças', 219.90, 4);

-- Instrutor 5: Roberto Lima
INSERT INTO curso (titulo, categoria, preco, codigoinstrutor) VALUES
('Fotografia Básica', 'Fotografia', 159.90, 5),
('Edição de Imagens', 'Fotografia', 189.90, 5),
('Fotografia de R', 'Fotografia', 179.90, 5),
('Fotografia de P', 'Fotografia', 199.90, 5),
('Iluminação', 'Fotografia', 219.90, 5);

select *from instrutor
select *from curso

-- PARTE 3

select c.titulo, i.nome, c.preco
from curso c
inner join instrutor i on i.codigo = c.codigoinstrutor
where c.preco > 100
order by c.preco DESC;

-- PARTE 4

select c.titulo, i.nome, c.preco
from curso c
full join instrutor i on i.codigo = c.codigoinstrutor
order by c.preco DESC;

-- PARTE 5

select i.nome, count(c.titulo) as Quantidade
from curso c
inner join instrutor i on i.codigo = c.codigoinstrutor
group by i.nome

select i.nome, AVG(c.preco) as Media
from curso c
inner join instrutor i on i.codigo = c.codigoinstrutor
group by i.nome

-- Parte 6

create view cursos_premium as
select c.titulo, i.nome, c.preco
from curso c
inner join instrutor i on i.codigo = c.codigoinstrutor
where c.preco > 150

alter view cursos_premium as
select c.titulo, i.nome, c.preco
from curso c
inner join instrutor i on i.codigo = c.codigoinstrutor
where c.preco > 200

select *from cursos_premium

-- parte 7

create procedure valor_curso
@valor float
as
select c.titulo,c.preco
from curso c 
where c.preco > @valor

exec valor_curso 100

-- parte 8

create procedure qtd_curso
as
begin
declare @qtd int
select @qtd = count(c.titulo)
from curso c
if @qtd > 8
	print('Plataforma grande')
else
	print('Plataforma pequena')
end

exec qtd_curso

-- parte 9

alter procedure instrutor_existe
@nome varchar(30)
as
begin
	declare @existe int
	select @existe = count(*) from instrutor where nome = @nome
	
if @existe = 0
   print('Instrutor nao encontrado')
else
begin
	declare @qtde int
   select @qtde = count(*) 
   from curso c
   inner join instrutor i on i.codigo = c.codigoinstrutor
   where i.nome = @nome

   print('Instrutor: ' + @nome + ' Quantidade de Curso: ' + convert(varchar, @qtde))
end
end

exec instrutor_existe 'Carlos Silva'

-- parte 10

declare @num int = 2

while (@num <=10)
begin
	print('Par: ' + convert(varchar, @num))
	set @num = @num + 2
end

-- parte 11

create procedure consulta_dinamica
  @categoria varchar(50),
  @valor float
as
begin
  declare @sql varchar(500)

  set @sql = 'select titulo, categoria, preco from curso where 1=1 '

  -- filtro por categoria
  if @categoria is not null
    set @sql = @sql + 'and categoria = ''' + @categoria + ''' '

  -- filtro por preço
  if @valor is not null
    set @sql = @sql + 'and preco >= ' + convert(varchar, @valor)

  exec(@sql)
end

exec consulta_dinamica 'Programação', 100
exec consulta_dinamica null, 100
exec consulta_dinamica 'Design', null