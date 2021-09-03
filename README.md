# Criando uma solução de e-commerce com microsserviços em Java - Backend - Checkout
Neste projeto desenvolvi o backend de uma solução de e-commerce com a arquitetura de microsserviços, a qual apliquei a integração entre eles orientada a eventos com Apache Kafka e garanti a compatibilidade entre da comunicação dos microsserviços com Schema Registry. Para isso, programei em Java utilizando a stack do Spring (Spring Boot, Spring Cloud Streams).

## Requisitos
- Java
- Docker
- IDE

## Acesse as outras partes do projeto
- [Payment](https://github.com/FernandaMakiHirose/ecommerce-payment-api)
- [Frontend](https://github.com/FernandaMakiHirose/ecommerce-checkout-frontend)

## Configuração do Spring Initializr
1) Acesse esse [site.](https://start.spring.io/)
- Project: Gradle Project
- Language: Java
- Spring Boot: 2.3.1
- Packaging: Jar
- Java: 14
- Dependências: Spring Web, Sleuth, Cloud Stream, Spring for Apache Kafta Streams, Spring Data JPA

## Entendendo o código
`docker-compose.yml`: Define qual serviço subir, para isso define um banco de dados para a API de checkout, banco de dados para a API de pagamento, zookeeper, kafka, schema-registry. <br>
`bootstrap.yml`: Define o nome da aplicação.

## Docker Compose
Se você navegar na pasta do Docker Compose e digitar o comando `docker-compose` você abra a lista de comandos dele.

Para subir: 
>docker-compose up --build -d

Ver todos os containers que estão rodando:
>docker ps
