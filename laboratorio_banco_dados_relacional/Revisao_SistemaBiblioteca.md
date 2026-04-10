# 📝 EXERCÍCIO – Sistema de Biblioteca

## 🎯 Objetivo
Criar um banco de dados para gerenciar **autores e livros**, aplicando conceitos de banco de dados relacional.

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
- `codigoautor` (FK referenciando autor.codigo)

---

## 📌 PARTE 2 – Inserção de Dados

### 🔹 3. Inserir dados
- Inserir pelo menos **5 autores**
- Inserir pelo menos **5 livros**
- Garantir que cada livro esteja vinculado a um autor

---

## 📌 PARTE 3 – SELECT + WHERE + ORDER BY

### 🔹 4. Consulta
- Listar livros com preço maior que 50  
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

### 🔹 7. Média de preço por autor
- Mostrar:
  - Nome do autor  
  - Média de preço dos livros  

---

## 📌 PARTE 6 – VIEW

### 🔹 8. Criar VIEW `livros_caros`
- Livros com preço maior que 70  
- Mostrar:
  - Título  
  - Autor  
  - Preço  

---

### 🔹 9. Consultar a VIEW
```sql
select * from livros_caros