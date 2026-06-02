create database labBD_fatec
use labBD_fatec

create table marca (codigo int not null identity(1,1),
                    marca varchar(20),
					constraint pk_marca primary key (codigo))
select * from marca 

insert into marca values ('Ford'), ('VW'),('Honda'), ('BYD'),
                         ('Hyundai'),('Toyota'),('Jeep'),
						 ('Chery'),('Fiat'),('GWM'),('Gm'),
						 ('Renault'),('Peugeot'),('Mercedes'),
						 ('BMW'),('Porsche'),('Audi')

create table veiculo (placa varchar(7) not null, 
                      codigomarca int, modelo varchar(50),
					  cor varchar(15), anofabricacao int,
					  valorfipe float, 
				constraint pk_veiculo primary key (placa))

select * from veiculo 

insert into veiculo values 
                 ('CDE9812',1,'Ka','Preto',2015,40000),
				 ('DWH1011',3,'Civic','Prata',2020,80000)

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
         ('OMT1711',17,'R8','Prata',2025,1750000,'Gasolina'),
         ('NXZ1920',2,'Saveiro','Preto',2011,37000, 'Flex'),
         ('DQP9833',15,'320i','Azul',2023,250000, 'Turbo'),
         ('FER3254',7,'911 Carrera 4S','Marrom',2025,860000,'Gasolina'),
         ('FBA1045',7,'Renegade','Preto',2026,140000,'Flex'),
         ('FGL7612',9,'Palio','Preto',2002,20000,'Gasolina'),
         ('EVK4471',16,'Panamera','Preto',2022,400000,'Flex'),
         ('EDZ1234',9,'500','Branco',2017,65000,'Flex'),
         ('BZG2775',17,'Celta','Azul',1998,25000, 'Gasolina'),
         ('EMI2811',9,'Grand Siena','Branco',2013,50000, 'Flex'),
         ('BWO9997',9,'Doblo','Prata',2007,27000,'Flex'),
         ('EMI8821',13,'Grand Siena','Branco',2013,245000,'Flex')

select * from veiculo

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

/*consultas 
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
order by v.modelo

select * from marca
select * from veiculo 

select m.marca, count(v.placa)
from marca m inner join veiculo v on m.codigo=v.codigomarca
group by m.marca
order by m.marca

/* views - visões. 
são componentes quer permitem armazenamento de selects 
dentro da estrutura do BD. 
são tambem consideradas tabelas virtuais. 
*/
create view listaveiculos 
as 
  select v.placa, v.modelo, v.cor
  from veiculo v
--------------- fim da view

select * from listaveiculos 

update listaveiculos set cor = 'Amarelo' where placa='BWO9997'

select * from veiculo 

insert into listaveiculos values ('AIA3812','Corsa','Azul')

create view qtd_veiculo_marca
as 
  select m.marca, count(v.placa) as 'qtd'
  from marca m inner join veiculo v on m.codigo=v.codigomarca
  group by m.marca
-- fim view

select qtd, marca
from qtd_veiculo_marca
where qtd > 3

create view velhinhos 
as 
  select v.modelo, v.cor, m.marca, v.anofabricacao 
  from marca m inner join veiculo v on m.codigo=v.codigomarca
  where v.anofabricacao < 2000
-- fim da view 

select marca, modelo, cor
from velhinhos 
where anofabricacao < 1970
order by anofabricacao 

/* stored procedures - Procedimentos
bloco de codigo com lógica de programação,
representando a regra de negócio da aplicação x banco
aqui é possível utilziar variaveis, if, laco, etc. 
*/
create procedure listaveiculo1 
  -- inserir os parametros.
  @ano int
as 
  select modelo, cor 
  from veiculo
  where anofabricacao > @ano 
-- fim procedure

exec listaveiculo1 2021
execute listaveiculo1 2025

alter procedure listaveiculo1 
  @ano int,
  @marca varchar(10)
as 
  select modelo, cor,marca 
  from velhinhos
  where anofabricacao > @ano and marca = @marca 
-- fim procedure

exec listaveiculo1 1900,'Fiat'

alter procedure listaveiculos2 
  @valor int  --parametros da procedure
as
  declare @qtd int -- variavel interna
  set @qtd = 10
  print ('valor atual' + convert(varchar,@qtd))
  set @qtd = @valor * 10
  print ('valor final '+ convert(varchar,@qtd))
-- fim da procedure

exec listaveiculos2 100

create procedure listaveiculo3
as
  declare @qtd int
  set @qtd = (select count(v.placa) from veiculo v)
  print ('Qtd de veiculo encontrado ' + convert(varchar,@qtd))
---------

exec listaveiculo3




alter procedure listaveiculo3
  @valorveiculo float
as
  declare @qtd int
  set @qtd = (select count(v.placa) from veiculo v
              where valorfipe < @valorveiculo)
  print (convert(varchar,@qtd) + ' veiculos encontrdos 
     com o valor (R$) de até '+ convert(varchar,@valorveiculo))
---------
exec listaveiculo3 20000
exec listaveiculo3

/* Exercicios 
1 - criar uma view para armazenar como relatório os veiculos
que possuem ano de fabriação superior a 2024 e cor prata. 
No resultado da view apresentar o modelo, marca, placa, cor e
ano de fabricação. 

2 - Criar uma procedure com um parametro marca que apresente
uma mensagem da quantidade de veículos encontrados no banco
com a marca que foi passada por parametro. 
*/
----codigo esta em https://codeshare.io/G8LVAD

create view exercicio1 
as 
 select v.modelo, m.marca, v.placa, v.cor, v.anofabricacao
 from marca m inner join veiculo v on m.codigo=v.codigomarca
 where v.anofabricacao > 2024 and v.cor = 'Prata'

 select marca, modelo, placa from exercicio1

 create procedure exercicio2
 @marc varchar(10)
 as
  declare @qtd int
  set @qtd = (select count(v.placa) 
              from marca m inner join veiculo v on m.codigo=v.codigomarca
			  where m.marca = @marc)
  print('Encontrado '+convert(varchar,@qtd)+' de veiculos da marca '+ @marc)
---

exec exercicio2 'Audi'

-- realizando algumas alterações no exercicio 
alter procedure exercicio2
 @marc varchar(10),@an int
 as
 declare @qt int
 set @qt = (select count(v.placa) 
             from marca m inner join veiculo v on m.codigo=v.codigomarca
   		     where m.marca = @marc)
 print('Encontrado '+convert(varchar,@qt)+' de veiculos da marca '+ @marc)
 set @qt = (select count(v.placa) from veiculo v where anofabricacao = @an)
 print('Encontrado '+convert(varchar,@qt) + ' veiculos do ano '+convert(varchar,@an))
 set @qt = (select count(v.placa) from marca m inner join veiculo v on m.codigo=
            v.codigomarca where m.marca = @marc and v.anofabricacao = @an)
 print('Encontrado '+convert(varchar,@qt)+ 'veiculos da marca '+@marc+ ' e do ano '+
       convert(varchar,@an))
---
exec exercicio2 'fiat',1964

alter procedure decisao 
@ano float
as 
  declare @media float
  declare @qtd int
  set @media = (select avg(valorfipe) from veiculo where anofabricacao < @ano)
  if @media is null 
    print (' O valor da média bugou. Não encontrei veículos inferior a '
	                                                 +convert(varchar,@ano))
  else
    print (' Média do valor dos veículos inferior a ' +convert(varchar,@ano)
	                   + ' é R$' + convert(varchar,convert(numeric(10,2),@media)))
---
exec decisao 22000
--https://codeshare.io/G8LVAD

alter procedure antigonovo
@opcao varchar(1)
as
  declare @inf varchar(200)= ''
  declare @valor int
  if @opcao = 'V' or @opcao = 'v' 
  begin
       set @valor = (select min(anofabricacao) from veiculo)
	   set @inf = @inf + 'O veículo mais antigo tem '+ convert(varchar,@valor) +' anos'
  end else begin
       if @opcao = 'N' or @opcao = 'n'
	   begin
	   	   set @valor = (select max(anofabricacao) from veiculo)
           set @inf = @inf + 'O veículo mais novo tem '+ convert(varchar,@valor) +' anos'
       end else begin
	       print ('parametro opção incorreto')
	   end
 end
  print (@inf)
  ---
  execute antigonovo 'x'

 /*Exercício.
 Criar uma procedure para simular uma calculadora. 
 A procedure deve receber 3 parametros, Operação, valor 1 e valor 2. 
 As operações (+ - * /) deve calcular e apresentar o valor com 
 print.
 */
alter procedure calculadora
  @oper varchar(1), @vl1 float, @vl2 float
 as
  declare @resultado float 
  declare @mensagem varchar(200) = ''
  if @oper = '+' set @resultado = @vl1 + @vl2
  if @oper = '/' set @resultado = @vl1 / @vl2
  if @oper = '*' set @resultado = @vl1 * @vl2
  if @oper = '-' set @resultado = @vl1 - @vl2
  if @oper <> '+' and @oper <> '/' and @oper <> '-' and @oper <> '*' begin
    print ('Opção invalida')
  end else begin
    set @mensagem = 'O resultado de '+convert(varchar,@vl1)+' '
                     +@oper+' '+convert(varchar,@vl2)+ 
				    ' é igual a '+convert(varchar,@resultado)
    print(@mensagem)
	insert into log values (getdate(),@mensagem)
  end
--- fim procedure
				 
exec calculadora '*',10,12	

create table log (sequencia int not null identity(1,1), momento datetime, 
                  ocorrencia varchar(255))

select * from log

-- procedure para pesquisar uma marca no banco. se encontrar a marca, apresentar 
--a qtd de veiculos cadastrados nessa marca, senão cadastrar a marca na tabela. 
alter procedure validamarca 
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
	insert into log values (getdate(),'Cadastrado a marca '+@marca)
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

select * from marca
select * from veiculo
select * from proprietario

select placa from veiculo 

update veiculo set proprietario = 101 where placa in ('AAA1961','AIA3812')
update veiculo set proprietario = 103 where placa in ('BBB1962','BWO9997','BZG2775',
'CCA1011','CCC1963','CDE9812','DDD1964')
update veiculo set proprietario = 102 where placa in ('DQP9833','DWH1011','EDZ1234',
'EEE1965','EMI2811','EMI8821','EVK4471','FBA1045','FER3254','FFF1966')
update veiculo set proprietario = 106 where placa in ('FGL7612','FMU4G99')
update veiculo set proprietario = 104 where placa in (
'GGG1967','HAU4468','HHH1968','III1969','JJJ1960','KKK2024','LLL2025','MMM2024','NNN2025',
'NXZ1920','OMT1711','OOO2024','PPP2025','QQQ2024','RRR2025','SSS2024','TTT2025','XWA9914')

alter procedure cadastra_veiculo 
@placa varchar(7), @marca varchar(10), @modelo varchar(30), @cor varchar(30), @ano int,
@valor float, @motor varchar(15), @proprietario varchar(50)
as
   if @placa <> '' begin
       declare @existemarca int = 0, @existepropr int = 0 
	   set @existemarca = (select count(codigo) from marca where marca = @marca)
	   set @existepropr = (select count(codigo) from proprietario where nome=@proprietario)
	   if @existemarca = 0 begin
	       insert into marca values (@marca)
		   print ('Cadastrado a nova marca '+@marca)  end
	   declare @codigomarca int 
       set @codigomarca = (select codigo from marca where marca = @marca)
	   if @existepropr = 0 begin
	      insert into proprietario (nome) values (@proprietario)
		  print ('Cadastrado proprietario, preencher o restante dos dados') end
	  declare @codigopr int
	  set @codigopr = (select codigo from proprietario where nome=@proprietario)
	  insert into veiculo values (@placa,@codigomarca,@modelo,@cor,@ano,@valor,
	                               @motor, @codigopr)
      insert into log values (getdate(),'Cadastrado novo veículo '+@modelo) 
   end else begin
       print ('Placa inválida')
   end
----- fim procedure
exec cadastra_veiculo 'AAA1130','FU','Cak','Branco',2010,140000,'Eletrico','Maicon'

select * from marca
select * from veiculo 
select * from proprietario 

-- procedures para consulta dinamica
alter procedure consulta_dinamica
 @modelo varchar(20), @ano int, @cor varchar(10)
as
  declare @sql varchar(500)
  set @sql = 'select placa, modelo, cor, anofabricacao '
  set @sql = @sql + 'from veiculo '
  set @sql = @sql + 'where 1=1 '
  if @modelo is not null 
     set @sql = @sql + ' and modelo = '''+@modelo+''''
  if @ano is not null
     set @sql = @sql + ' and anofabricacao = '+convert(varchar,@ano)
  if @cor is not null
     set @sql = @sql + ' and cor = ''' +@cor+''''
  exec (@sql)
---- fim
exec consulta_dinamica 'civic',2000,null

-- exercicio. 
-- criar uma procedure para deletar um proprietario do banco de dados.
-- ao deletar observar se existe algum veículo cadastrado para ele. 
-- se tiver, avisar por mensagem a qtd de veículos que foi excluida
-- para depois excluir o proprietario. 
-- antes de excluir o proprietario verificar se ele existe. 
-- para executar a procedure utilziar exec excluir_proprietario 'maria'
create procedure excluir_proprietario
  @nome varchar(100)  as
  declare @existepropr int=0
  set @existepropr = (select count(nome) from proprietario where nome = @nome)
  if @existepropr > 0 
  begin
    declare @existeveiculo int=0, @qualcodigo int=0
	set @qualcodigo = (select codigo from proprietario where nome = @nome)
	set @existeveiculo = (select count(placa) from veiculo where proprietario=@qualcodigo)
	if @existeveiculo > 0 
	begin
	   print ('Esta sendo excluído do '+ @nome + convert(varchar,@existeveiculo)+ 'veiculos')
	   delete from veiculo where proprietario = @qualcodigo
    end
	delete from proprietario where nome = @nome 
  end else 
    print ('proprietario não encontrado')
-- fim procedure

exec excluir_proprietario 'maria'
select * from veiculo 
select * from proprietario

-- procedures parametro de retorno 
alter procedure parametros 
  @valora int, @valorb int output
as
  if @valora is not null
  begin
     set @valorb = @valora
	 set @valorb +=2
  end else 
     print ('detectado que valora é nulo')
--------fim da procedure
declare @num int
exec parametros 20, @valorb=@num output
print ('valor de retorno ' + convert(varchar,@num))

select * from veiculo
create procedure calculolucro
  @marca varchar(10), @lucro float output
as
  declare @valormedio float
  declare @qtdveiculo int=0
  set @qtdveiculo = (select count(placa) from veiculo v inner join marca m
                     on v.codigomarca=m.codigo where m.marca = @marca)
  if @qtdveiculo > 0 
  begin
       set @valormedio = (select avg(v.valorfipe) from veiculo v inner join 
                     marca m on m.codigo=v.codigomarca where m.marca=@marca)
       set @lucro = @valormedio * 1.30
  end else 
      print ('Não foi encontrado veiculos dessa marca')
--- fim procedure
declare @lucroliquido int
exec calculolucro 'xxx', @lucro=@lucroliquido output
print ('valor do lucro ' + convert(varchar,@lucroliquido))


alter procedure texto
  @info varchar(50)
as
  declare @resultado varchar(50)='',@cont int=0
  set @cont = len(@info)
  while (@cont > 0)
  begin
     set @resultado = @resultado + substring(@info,@cont,1)
	 set @cont -=1
  end
  print (@info + ' -> '+@resultado)
  --- fim da procedure
   exec texto 'Fatec Lab Banco' 


--- AULA 17/04/2026 ---

CREATE TABLE emprestimo (sequencia int not null identity(1,1),
                         ano int, mes int, numeroparcela int,
                         valorparcela int,
                         constraint pk_emprestimo primary key (sequencia))

CREATE PROCEDURE gerar_emprestimo 
@valoremprestimo float, @qtdparcela int
as
    DECLARE @ano int = year(getdate())
    DECLARE @mes int = month(getdate())
    set @mes += 1
    DECLARE @parcela int = 1
    DECLARE @valorparcela float = (@valoremprestimo/@qtdparcela)
    WHILE (@qtdparcela > 0 )
    begin
        insert into emprestimo values (@ano,@mes,@parcela,@valorparcela)
        set @mes +=1
        set @parcela +=1
        set @qtdparcela -=1
    end
--fim

exec gerar_emprestimo 20000, 12
select *from emprestimo

alter PROCEDURE gerar_emprestimo 
@valoremprestimo float, @qtdparcela int
as
    DELETE from emprestimo
    DECLARE @ano int = year(getdate())
    DECLARE @mes int = month(getdate())
    set @mes += 1
    DECLARE @parcela int = 1
    DECLARE @valorparcela float = (@valoremprestimo/@qtdparcela)
    WHILE (@qtdparcela > 0 )
    begin
        insert into emprestimo values (@ano,@mes,@parcela,@valorparcela)
        IF @mes >= 12 
            begin set @mes = 1 
            set @ano += 1
            end
        else
            set @mes +=1
        set @parcela +=1
        set @qtdparcela -=1
    end
--fim

exec gerar_emprestimo 20000, 230
select *from emprestimo

--COM JUROS

ALTER PROCEDURE juros_simples 
    @valoremprestimo FLOAT, 
    @qtdparcela INT, 
    @taxajuros FLOAT
AS
BEGIN
    DELETE FROM emprestimo

    DECLARE @ano INT = YEAR(GETDATE())
    DECLARE @mes INT = MONTH(GETDATE()) + 1
    DECLARE @parcela INT = 1
    DECLARE @saldo FLOAT = @valoremprestimo

    DECLARE @juros_total FLOAT = 0

    WHILE (@qtdparcela > 0)
    BEGIN
        DECLARE @juros FLOAT = @saldo * @taxajuros
        DECLARE @valorparcela FLOAT = (@saldo / @qtdparcela) + @juros

        SET @juros_total += @juros

        INSERT INTO emprestimo (ano, mes, numeroparcela, valorparcela)
        VALUES (@ano, @mes, @parcela, @valorparcela)

        SET @saldo -= (@saldo / @qtdparcela)

        -- controle de data
        IF @mes >= 12 
        BEGIN 
            SET @mes = 1 
            SET @ano += 1
        END
        ELSE
            SET @mes += 1    

        SET @parcela += 1
        SET @qtdparcela -= 1
    END

    PRINT 'Total de juros pago: ' + CAST(@juros_total AS VARCHAR)
END
--fim


/* exercicio 

1. alterar a procedure atual, considerar apresentar no final da procedure
um print com o valor dos juros que será pago

2. criar uma procedure de juros_compostos que considera as parcelas
definidas atraves do conceito de juros composto
*/

create PROCEDURE juros_compostos
    @valoremprestimo FLOAT,
    @qtdparcela INT,
    @taxajuros FLOAT
AS
BEGIN
    DELETE FROM emprestimo

    DECLARE @ano INT = YEAR(GETDATE())
    DECLARE @mes INT = MONTH(GETDATE()) + 1
    DECLARE @parcela INT = 1
    DECLARE @saldo FLOAT = @valoremprestimo

    DECLARE @juros_total FLOAT = 0

    -- fórmula PRICE
    DECLARE @potencia FLOAT = POWER(1 + @taxajuros, @qtdparcela)

    DECLARE @valorparcela FLOAT =
        @valoremprestimo * (@taxajuros * @potencia) / (@potencia - 1)

    WHILE (@parcela <= @qtdparcela)
    BEGIN
        DECLARE @juros FLOAT = @saldo * @taxajuros
        DECLARE @amortizacao FLOAT = @valorparcela - @juros

        SET @juros_total += @juros

        INSERT INTO emprestimo (ano, mes, numeroparcela, valorparcela)
        VALUES (@ano, @mes, @parcela, @valorparcela)

        SET @saldo -= @amortizacao

        -- controle de data
        IF @mes >= 12 
        BEGIN 
            SET @mes = 1 
            SET @ano += 1
        END
        ELSE
            SET @mes += 1    

        SET @parcela += 1
    END

    PRINT 'Total de juros pago: ' + CAST(@juros_total AS VARCHAR)
END

EXEC juros_simples 
    @valoremprestimo = 20000, 
    @qtdparcela = 12, 
    @taxajuros = 0.02

SELECT * FROM emprestimo

EXEC juros_compostos 
    @valoremprestimo = 20000, 
    @qtdparcela = 12, 
    @taxajuros = 0.02

SELECT * FROM emprestimo

