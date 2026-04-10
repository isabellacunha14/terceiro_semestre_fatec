# 🧪 PROVA SURPRESA – BANCO DE DADOS (NÍVEL DIFÍCIL)

## 🎯 Tema: Sistema de Cursos Online

---

## 📌 PARTE 1 – MODELAGEM

### 🔹 1. Criar o banco de dados
Crie o banco de dados chamado `SistemaCursos`.

---

### 🔹 2. Criar tabela `instrutor`
Campos:
- `codigo` (INT, PK, IDENTITY)
- `nome` (VARCHAR)
- `especialidade` (VARCHAR)

---

### 🔹 3. Criar tabela `curso`
Campos:
- `id` (INT, PK, IDENTITY)
- `titulo` (VARCHAR)
- `categoria` (VARCHAR)
- `preco` (FLOAT)
- `codigoinstrutor` (FK → instrutor.codigo)

---

## 📌 PARTE 2 – INSERÇÃO DE DADOS

### 🔹 4. Inserir dados
- Inserir pelo menos **5 instrutores**
- Inserir pelo menos **10 cursos**
- Garantir relacionamento correto (FK)

---

## 📌 PARTE 3 – SELECT + WHERE + ORDER BY

### 🔹 5. Consulta
- Listar cursos com preço maior que 100  
- Ordenar do maior para o menor  

---

## 📌 PARTE 4 – FULL JOIN

### 🔹 6. Consulta com FULL JOIN
- Mostrar:
  - título do curso  
  - nome do instrutor  
  - preço  
- Trazer todos os registros, mesmo sem relacionamento  

---

## 📌 PARTE 5 – GROUP BY + FUNÇÕES

### 🔹 7. Quantidade de cursos por instrutor
- Mostrar:
  - nome do instrutor  
  - quantidade de cursos  

---

### 🔹 8. Média de preço dos cursos por instrutor
- Mostrar:
  - nome do instrutor  
  - média de preço  

---

## 📌 PARTE 6 – VIEW

### 🔹 9. Criar VIEW `cursos_premium`
- Cursos com preço maior que 150  
- Mostrar:
  - título  
  - instrutor  
  - preço  

---

### 🔹 10. Consultar a VIEW
```sql
select * from cursos_premium