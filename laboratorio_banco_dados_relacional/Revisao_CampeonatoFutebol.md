# 📝 📚 EXERCÍCIO – Banco de Dados (Sistema de Biblioteca)

## 🎯 Objetivo
Criar um banco de dados para controle de **livros e autores**, aplicando conceitos de SQL como:
- CREATE
- INSERT
- SELECT
- JOIN
- GROUP BY
- VIEW
- PROCEDURE
- WHILE

---

## 📌 PARTE 1 – Criação das Tabelas

### 🔹 1. Criar tabela `autor`
Campos:
- `codigo` (INT, PK, IDENTITY)
- `nome` (VARCHAR)
- `pais` (VARCHAR)

---

### 🔹 2. Criar tabela `livro`
Campos:
- `id` (INT, PK, IDENTITY)
- `titulo` (VARCHAR)
- `genero` (VARCHAR)
- `preco` (FLOAT)
- `codigoautor` (FK → autor.codigo)

---

## 📌 PARTE 2 – Inserção de Dados

### 🔹 3. Inserir dados
- Inserir pelo menos **5 autores**
- Inserir pelo menos **5 livros**
- Cada livro deve estar relacionado a um autor

---

## 📌 PARTE 3 – SELECT + WHERE + ORDER BY

### 🔹 4. Consulta
- Listar todos os livros com preço maior que 50  
- Ordenar pelo preço  

---

## 📌 PARTE 4 – JOIN

### 🔹 5. Consulta com JOIN
- Mostrar:
  - Título do livro  
  - Nome do autor  

---

## 📌 PARTE 5 – GROUP BY + FUNÇÕES

### 🔹 6. Quantidade de livros por autor
- Mostrar:
  - Nome do autor  
  - Quantidade de livros  

---

### 🔹 7. Média de preços
- Mostrar:
  - Nome do autor  
  - Média de preço dos livros  

---

## 📌 PARTE 6 – VIEW

### 🔹 8. Criar VIEW `livros_caros`
- Livros com preço > 70  
- Mostrar:
  - Título  
  - Autor  
  - Preço  

---

### 🔹 9. Consultar a VIEW
- Usar `SELECT * FROM livros_caros`

---

## 📌 PARTE 7 – PROCEDURE (com parâmetro)

### 🔹 10. Criar PROCEDURE
- Receber um valor de preço  
- Mostrar livros com preço maior que o valor informado  

---

## 📌 PARTE 8 – PROCEDURE com IF

### 🔹 11. Criar PROCEDURE
- Contar quantos livros existem  
- Se > 5 → “Muitos livros”  
- Senão → “Poucos livros”  

---

## 📌 PARTE 9 – WHILE

### 🔹 12. Criar um WHILE
- Exibir números de 1 até 5  

---

## 📌 PARTE 10 – DESAFIO FINAL

### 🔹 13. Criar PROCEDURE
- Receber nome de um autor  
- Se existir:
  - Mostrar quantidade de livros dele  
- Se não existir:
  - Mostrar “Autor não encontrado”  

---

## 🚀 Dica Final
Este exercício cobre praticamente todos os conteúdos cobrados em prova de Banco de Dados Relacional.

👉 Faça tudo sem consultar e depois revise.