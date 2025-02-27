<h1 align="center">
  Exemplo API RESTful com Spring Boot
</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.1.5-green" alt="Spring Boot">
  <img src="https://img.shields.io/badge/PostgreSQL-16.0-blue" alt="PostgreSQL">
  <img src="https://img.shields.io/badge/OpenAPI-3.0-orange" alt="OpenAPI">
</p>

Este projeto é um exemplo de uma aplicação Spring Boot que implementa uma API RESTful, seguindo o modelo de maturidade de Leonard Richardson. A API gerencia produtos, permitindo operações básicas de CRUD (Create, Read, Update, Delete) com integração ao banco de dados PostgreSQL.

---

## Tecnologias Utilizadas

- **[Spring Boot](https://spring.io/projects/spring-boot)**: Framework para desenvolvimento de aplicações Java.
- **[Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)**: Para criação de endpoints RESTful.
- **[Spring Data JPA](https://spring.io/projects/spring-data-jpa)**: Para acesso e manipulação de dados no banco de dados.
- **[SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)**: Para documentação automática da API.
- **[PostgreSQL](https://www.postgresql.org/download/)**: Banco de dados relacional utilizado para persistência de dados.

---

## Práticas Adotadas

- **SOLID e DRY**: Princípios de design de software para código limpo e manutenível.
- **API RESTful**: Seguindo as boas práticas de desenvolvimento de APIs REST.
- **Consultas com Spring Data JPA**: Utilização de repositórios para operações no banco de dados.
- **Injeção de Dependências**: Gerenciamento de dependências com Spring.

---


## Como Executar

- Clonar repositório git

```
git clone https://github.com/Macinao/exemplo-spring-restful.git
```
- Abra o projeto com uma IDE
    *  Recomendo utilizar IntelliJ IDEA ou Eclipse.
- Crie um banco de dados postgresql
```
CREATE DATABASE nome_do_banco;
```
- Configure o application.propeties para persistir em seu banco
```
spring.datasource.url=jdbc:postgresql://localhost:5432/nome-banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
```
- Execute o programa
```
SpringbaseApplication:run
```

---

## Pré-requisitos

- Java 17 ou superior.
- PostgreSQL instalado e configurado.
- [Git](https://git-scm.com/) instalado.

---

## API Endpoints

A API poderá ser acessada utilizando o postman ou semelhantes para realizar as requisições HTTP.


- Criar Produto
```
POST localhost:8080/products

{
    "nameProduct":  "Batedeira",
    "valueProduct":  2000
}
```

- Buscar Produto
```
GET localhost:8080/products/id-do-produto

{
    "idProduct": "e7f12465-8c59-4a72-9d20-4f5f04fc1354",
    "nameProduct": "Batedeira",
    "valueProduct": 2000
}

```

- Listar Produtos
```
GET localhost:8080/products

{
    "idProduct": "e7f12465-8c59-4a72-9d20-4f5f04fc1354",
    "nameProduct": "Batedeira",
    "valueProduct": 2000
}

```

- Atualizar Produto
```
PUT localhost:8080/products/45a6ec9e-e554-4b47-a0b4-7d131f23ecde

{
    "nameProduct":  "Smartphone LG",
    "valueProduct":  1000
}
```

- Deletar Produto
```
DELETE localhost:8080/products/45a6ec9e-e554-4b47-a0b4-7d131f23ecde

[]
```