CREATE DATABASE CampeonatoFutebol

USE CampeonatoFutebol

CREATE TABLE time (codigo int not null identity(1,1),
					nome varchar(10), 
					cidade varchar(20),
					constraint pk_time primary key (codigo))


CREATE TABLE jogador (id int not null identity(1,1), 
						nome varchar (20),
						posicao varchar (10),
						salario float,
						codigotime int,
						constraint pk_jogador primary key (id), --pk do jogador
						constraint fk_jogador_time --fk do jogador com time
							foreign key (codigotime) references time(codigo))

INSERT INTO time (nome, cidade) 
	values ('Corinthians', 'Sao Paulo'),
			('Santos','Santos'),
			('Flamengo','Rio de Janeiro'),
			('Sao Paulo', 'Sao Paulo'),
			('Fluminense', 'Rio de Janeiro')

ALTER TABLE time
alter column nome varchar(30)

-- Corinthians (codigotime = 2)
INSERT INTO jogador (nome, posicao, salario, codigotime) VALUES
('Hugo Souza', 'Goleiro', 5500, 2),
('Andre Ramalho', 'Zagueiro', 4800, 2),
('Gabriel Paulista', 'Zagueiro', 5000, 2),
('Matheuzinho', 'Lateral D', 4700, 2),
('Matheus Bidu', 'Lateral E', 4600, 2),
('Breno Bidon', 'Volante', 5200, 2),
('Jesse Lingard', 'Meia', 5600, 2),
('Rodrigo Garro', 'Meia ', 5400, 2),
('Yuri Alberto', 'Atacante', 6000, 2),
('Memphis Depay', 'Atacante', 6500, 2);

-- Santos (codigotime = 3)
INSERT INTO jogador (nome, posicao, salario, codigotime) VALUES
('Daniel Martins', 'Goleiro', 5300, 3),
('Eduardo Nunes', 'Zagueiro', 4700, 3),
('Gabriel Torres', 'Zagueiro', 4900, 3),
('Henrique Lopes', 'Lateral D', 4600, 3),
('Rodrigo Pires', 'Lateral E', 4500, 3),
('Mateus Barros', 'Volante', 5100, 3),
('Leonardo Teixeira', 'Meia', 5500, 3),
('Paulo Henrique', 'Meia ', 5300, 3),
('Ricardo Almeida', 'Atacante', 6100, 3),
('Fernando Oliveira', 'Atacante', 6600, 3);

-- Flamengo (codigotime = 4)
INSERT INTO jogador (nome, posicao, salario, codigotime) VALUES
('Gustavo Ramos', 'Goleiro', 5600, 4),
('Diego Ferreira', 'Zagueiro', 4800, 4),
('Caio Moreira', 'Zagueiro', 5000, 4),
('Igor Batista', 'Lateral D', 4700, 4),
('Samuel Cardoso', 'Lateral E', 4600, 4),
('Vinicius Duarte', 'Volante', 5200, 4),
('Renato Azevedo', 'Meia', 5700, 4),
('Marcelo Pinto', 'Meia', 5400, 4),
('Alex Barbosa', 'Atacante', 6200, 4),
('Jorge Farias', 'Atacante', 6700, 4);

-- São Paulo (codigotime = 5)
INSERT INTO jogador (nome, posicao, salario, codigotime) VALUES
('Roberto Lima', 'Goleiro', 5400, 5),
('Sérgio Almeida', 'Zagueiro', 4700, 5),
('Maurício Costa', 'Zagueiro', 4900, 5),
('Fábio Nogueira', 'Lateral D', 4600, 5),
('Cláudio Ribeiro', 'Lateral E', 4500, 5),
('Bruno Teixeira', 'Volante', 5100, 5),
('Juliano Martins', 'Meia', 5600, 5),
('Douglas Vieira', 'Meia', 5300, 5),
('Cristiano Lopes', 'Atacante', 6100, 5),
('Adriano Souza', 'Atacante', 6600, 5);

-- Fluminense (codigotime = 6)
INSERT INTO jogador (nome, posicao, salario, codigotime) VALUES
('Paulo César', 'Goleiro', 5500, 6),
('Antônio Silva', 'Zagueiro', 4800, 6),
('Luiz Fernando', 'Zagueiro', 5000, 6),
('Marcelo Santos', 'Lateral D', 4700, 6),
('Rogério Almeida', 'Lateral E', 4600, 6),
('Carlos Eduardo', 'Volante', 5200, 6),
('Felipe Ramos', 'Meia', 5700, 6),
('Guilherme Torres', 'Meia', 5400, 6),
('Renan Oliveira', 'Atacante', 6200, 6),
('Tiago Barbosa', 'Atacante', 6700, 6);

select *from jogador
where salario > 5000
order by salario

select j.nome,t.nome
from jogador j
inner join time t on t.codigo = j.codigotime

select t.nome, count(j.nome)
from time t
inner join jogador j on t.codigo = j.codigotime
group by t.nome

select t.nome, avg(j.salario) as media
from jogador j
inner join time t on t.codigo = j.codigotime
group by t.nome

alter view jogadores_caros as 
select j.nome, j.salario, t.nome as time
from jogador j
inner join time t on t.codigo = j.codigotime
where salario >6000 --tive que alterar para 6000 pois maior que 8000 nao tinha

select *from jogadores_caros

alter procedure valor_salario --alterei colocando j.salario
@salario float
as
select j.nome, j.salario
from jogador j
where j.salario > @salario 

exec valor_salario 5000

create procedure qtd_jogador
as
begin
   declare @quantidade int

   select @quantidade = count(*)
   from jogador j
   inner join time t on t.codigo = j.codigotime

   if @quantidade > 5
      print('Muitos Jogadores')
   else
      print('Poucos Jogadores')
end

exec qtd_jogador

declare @num int = 1
while(@num <=5)
begin 
	print('Valor: ' + convert (varchar, @num))
	set @num = @num + 1
end

create procedure time_qtd_jogador
@nometime varchar (30)
as
begin 
	declare @quantidade int

	select @quantidade = count(*)
	from jogador j
	inner join time t on t.codigo = j.codigotime
	where t.nome = @nometime
	if @quantidade > 0
		print ('Qtde de jogadores: ' + convert(varchar, @quantidade))
	else
		print('Time nao Encontrado')
end

exec time_qtd_jogador 'Corinthians'
exec time_qtd_jogador 'Palmeiras'



