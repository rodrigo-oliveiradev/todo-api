# ✅ ToDo API - Sistema de Gestão de Tarefas Seguras

API REST robusta para gerenciamento de tarefas e usuários, desenvolvida com foco em **Segurança**, **Boas Práticas** e **Arquitetura Limpa**.

Este projeto faz parte do meu portfólio profissional, demonstrando domínio em Java Moderno, Spring Boot e Autenticação JWT.

---

## 🚀 Tecnologias e Ferramentas

* **Java 21** (LTS)
* **Spring Boot 3**
* **Spring Security** (Proteção de rotas)
* **JWT (JSON Web Token)** (Autenticação Stateless)
* **Spring Data JPA** & **MySQL** (Persistência)
* **Maven** (Gerenciamento de dependências)
* **Bean Validation** (Validação de dados de entrada)

---

## 🛡️ Segurança e Autenticação

O sistema utiliza **Spring Security** com **Filtros JWT** personalizados.
* **Rotas Públicas:** Cadastro de usuários e Login.
* **Rotas Privadas:** Criação e gestão de tarefas (exigem Token Bearer).
* **Criptografia:** Senhas são salvas com hash **BCrypt** no banco de dados.

---

## 📌 Funcionalidades Principais

* ✅ **Gestão de Usuários:** Cadastro seguro com senha criptografada.
* ✅ **Login & Token:** Geração de tokens JWT com expiração automática.
* ✅ **Gestão de Tarefas:** CRUD completo (Criar, Ler, Atualizar, Deletar).
* ✅ **Associação:** Tarefas são vinculadas automaticamente ao usuário logado.
* ✅ **Validações:** Tratamento de erros amigável para dados inválidos.

---

## 🔌 Endpoints da API

### 🔓 Autenticação (Público)
| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/auth/login` | Recebe email/senha e retorna o **Token JWT**. |
| `POST` | `/users` | Cria um novo usuário no sistema. |

### 🔒 Tarefas (Privado - Requer Token Bearer)
| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/tasks` | Cria uma nova tarefa. |
| `GET` | `/tasks` | Lista todas as tarefas do usuário. |
| `PUT` | `/tasks/{id}` | Atualiza o status ou dados de uma tarefa. |
| `DELETE` | `/tasks/{id}` | Remove uma tarefa. |

---

## ▶️ Como executar o projeto

### Pré-requisitos
1.  Ter o **Java 21** instalado.
2.  Ter o **MySQL** rodando na porta `3306`.
3.  Configurar o arquivo `src/main/resources/application.yaml` (se necessário).

### Passo a passo
1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/todo-api.git](https://github.com/seu-usuario/todo-api.git)
    ```
2.  **Configure o Banco de Dados:**
    Crie um schema vazio no MySQL chamado `todo_db`.
3.  **Execute a aplicação:**
    ```bash
    ./mvnw spring-boot:run
    ```
4.  **Acesse a API:**
    A aplicação rodará em `http://localhost:8080`.

---

## 🧱 Arquitetura do Projeto

O código segue o padrão de camadas para facilitar a manutenção e testes:
* `controller` - Camada REST (Entrada de dados).
* `service` - Regras de negócio e validações.
* `repository` - Comunicação com o banco de dados.
* `dto` - Objetos de transferência de dados (Records).
* `config` - Configurações de Segurança (Security/JWT).

---

👨‍💻 **Desenvolvido por Rodrigo Oliveira**
[LinkedIn](https://www.linkedin.com/in/rodrigo-oliveira-b71633170/)