# 📚 Sistema de Biblioteca - Empréstimo de Livros

## 📌 Sobre o projeto

Este projeto é um sistema simples desenvolvido em Java para gerenciamento de uma biblioteca, com foco na listagem de livros disponíveis e no controle de empréstimos.

O sistema funciona via console e simula o fluxo básico de uma biblioteca real.

---

## 🎯 Objetivo

Permitir que o usuário:
- Visualize livros disponíveis
- Realize empréstimos de livros
- Registre clientes e controle de empréstimos

---

## ⚙️ Como o sistema funciona

### 🔹 1. Início do sistema
O programa inicia em loop e pergunta ao usuário se deseja visualizar os livros disponíveis.

---

### 🔹 2. Listagem de livros
Se a resposta for **SIM**, o sistema exibe todos os livros que estão disponíveis para empréstimo.

---

### 🔹 3. Empréstimo de livro
O usuário pode:
- Escolher um livro pelo ID
- Informar seu nome
- Confirmar o empréstimo

O sistema então:
- Marca o livro como indisponível
- Registra o empréstimo
- Exibe mensagem de sucesso

---

### 🔹 4. Encerramento
O sistema encerra quando:
- O usuário responde **NÃO**, ou
- Após concluir um empréstimo

---

## 🧱 Estrutura do projeto

O projeto é dividido nas seguintes classes:

### 📘 Livro
- id: Identificador único
- titulo: Título do livro
- autor: Autor do livro
- disponivel: Status de disponibilidade
- dataCadastro: Data de criação
- dataAtualizacao: Última atualização

---

### 👨‍💼 Autor
- id: Identificador único
- nome: Nome do autor
- dataNascimento: Data de nascimento

---

### 📄 Emprestimo
- id: Identificador único
- livro: Livro emprestado
- nomeCliente: Nome do cliente
- dataEmprestimo: Data do empréstimo
- dataDevolucao: Data de devolução (opcional)

---

### 🏛️ Biblioteca
Gerencia toda a aplicação.

Contém:
- Lista de livros
- Lista de autores
- Lista de empréstimos

```java
private List<Livro> livros = new ArrayList<>();
private List<Autor> autores = new ArrayList<>();
private List<Emprestimo> emprestimos = new ArrayList<>();
