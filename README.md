# 🖼️ ImageRepo API

## 📌 Visão Geral

O **ImageRepo API** é um microserviço backend responsável pelo **gerenciamento e armazenamento de imagens**, desenvolvido com **Kotlin e Spring Boot**, seguindo os princípios do **SOLID e Clean Architecture** e boas práticas de desenvolvimento de software.

Este repositório contém **exclusivamente o microserviço de imagens**.
O microserviço de **cadastro e gerenciamento de usuários** é mantido em um repositório separado, reforçando o desacoplamento entre domínios e facilitando a evolução independente dos serviços.

---

## 🎯 Objetivo do Projeto

* Desenvolver uma **API REST** robusta e escalável
* Aplicar **Clean Architecture** de forma prática
* Gerenciar **upload, metadados e persistência de imagens**
* Persistir dados em **PostgreSQL**
* Preparar o serviço para integração com outros microsserviços
* Facilitar testes, manutenção e evolução do sistema

---

## 🧱 Arquitetura

O projeto segue os princípios da **Clean Architecture**, com clara separação de responsabilidades:

```
┌────────────────────┐
│   Controllers      │  ← Camada de entrada (HTTP)
├────────────────────┤
│   Use Cases        │  ← Regras de negócio
├────────────────────┤
│   Domain           │  ← Entidades e contratos
├────────────────────┤
│   Gateways         │  ← Interfaces de saída
├────────────────────┤
│   Infrastructure   │  ← Banco, JPA, Postgres
└────────────────────┘
```

### Princípios aplicados

* Dependências sempre apontam **para dentro**
* Regras de negócio **independentes de frameworks**
* Frameworks são **detalhes de implementação**
* Facilidade para testes unitários e de integração

---

## 🛠️ Tecnologias Utilizadas

### 🔹 Linguagem e Plataforma

* **Kotlin 1.9.25**
* **Java 21**
* **Spring Boot 3.5.9**

### 🔹 Frameworks e Bibliotecas

* **Spring Web**

    * APIs REST
* **Spring Data JPA**

    * Persistência e abstração de acesso a dados
* **Hibernate**

    * Implementação JPA
* **Jackson Kotlin Module**

    * Serialização e deserialização JSON com suporte completo ao Kotlin

### 🔹 Banco de Dados

* **PostgreSQL**

    * Banco relacional principal
    * Suporte a UUID
    * Preparado para uso em produção

### 🔹 Build e Gerenciamento

* **Maven**
* **Kotlin Maven Plugin**

    * `spring`
    * `jpa`
    * `all-open`
    * `no-arg`

### 🔹 Testes

* **JUnit 5**
* **Spring Boot Starter Test**
* **Kotlin Test (JUnit 5)**

---

## ▶️ Executando o Projeto

### Pré-requisitos

* Java 21
* Maven
* PostgreSQL

### Variáveis de ambiente (exemplo)

```bash
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/imagelite
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres
```

### Executar localmente

```bash
mvn spring-boot:run
```

A aplicação será iniciada em:

```
http://localhost:8080
```

---

## 🗄️ Banco de Dados

* Banco principal: **PostgreSQL**
* Gerenciamento de schema via **Hibernate (ddl-auto)**
* Estrutura preparada para uso de **UUID como chave primária**
* Compatível com execução local ou via Docker

---

## 🔮 Próximos Passos (Roadmap)

* Upload de imagens com armazenamento em:

    * File System
    * Object Storage (S3 / MinIO)
* Integração com microserviço de usuários
* Autenticação e autorização
* Observabilidade (logs e métricas)
* Documentação com OpenAPI / Swagger
* Integração com frontend em **React.js**

---

## 📄 Licença

Este projeto está em desenvolvimento e atualmente não possui uma licença definida.
