# Criando uma solução de e-commerce com microsserviços em Java - Backend
Neste projeto desenvolvi o backend de uma solução de e-commerce com a arquitetura de microsserviços, a qual apliquei a integração entre eles orientada a eventos com Apache Kafka e garanti a compatibilidade entre da comunicação dos microsserviços com Schema Registry. Para isso, programei em Java utilizando a stack do Spring (Spring Boot, Spring Cloud Streams).

## Configuração do Spring Initializr
1) Acesse esse [site.](https://start.spring.io/)
- Project: Gradle Project
- Language: Java
- Spring Boot: 2.3.1
- Packaging: Jar
- Java: 14
- Dependências: Spring Web, Sleuth, Cloud Stream, Spring for Apache Kafta Streams, Spring Data JPA

## Entendendo o código
`docker-compose.yml`: Define qual serviço subir, para isso define um banco de dados para a API de checkout, banco de dados para a API de pagamento, zookeeper, kafka, schema-registry. 
`bootstrap.yml`: Define o nome da aplicação.

## Docker Compose
Se você navegar na pasta do Docker Compose e digitar o comando `docker-compose` você abra a lista de comandos dele.

Para subir: 
>docker-compose up --build -d

Ver todos os containers que estão rodando:
>docker ps

## Sobre a Autora
Oi, eu sou a Fernanda! Estou aqui para contribuir com meu conhecimento e espero poder ajudar no desenvolvimento profissional de cada um de vocês.

[![Linkedin Badge](https://img.shields.io/badge/-Fernanda_Maki_Hirose-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/fernanda-maki-hirose-801117208/)](https://www.linkedin.com/in/fernanda-maki-hirose-801117208/)  [![Gmail Badge](https://img.shields.io/badge/-femahi2020@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:femahi2020@gmail.com)](mailto:femahi2020@gmail.com)
