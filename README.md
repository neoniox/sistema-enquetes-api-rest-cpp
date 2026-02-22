# sistema-enquetes-api-rest-cpp

Sistema de Enquetes – API REST (Spring Boot)

📌 Descrição
Aplicação web desenvolvida com Java e Spring Boot para gerenciamento de enquetes, permitindo criação, consulta, atualização e remoção de dados através de requisições HTTP.

O sistema segue o padrão de arquitetura REST e implementa operações completas utilizando os métodos:

POST;
GET;
PUT;
DELETE

A aplicação permite cadastrar enquetes com múltiplas opções de resposta, armazenando os dados em banco através de repositório JPA.

🚀 Funcionalidades

📝 Enquetes
Criar nova enquete;
Listar todas as enquetes;
Buscar enquete por ID;
Atualizar pergunta;
Deletar enquete

🔘 Opções de Voto
Associar múltiplas opções a uma enquete;
Persistência automática via relacionamento entre entidades;
Configuração de cascade para salvar opções junto com a enquete

🛠 Tecnologias Utilizadas
Java;
Spring Boot;
Spring Data JPA;
API REST;
Hibernate;
Maven;
Banco de dados relacional (ex: H2 / MySQL)

🧠 Conceitos Aplicados
Programação Orientada a Objetos (POO);
Arquitetura RESTful;
Mapeamento Objeto-Relacional (ORM);
Relacionamento entre entidades (@OneToMany);
Injeção de dependência;
Repositórios com Spring Data;
Inicialização automática de dados com CommandLineRunner

🔗 Estrutura da Aplicação

O projeto é organizado em camadas:
models → Entidades (Enquete, Opcao);
repository → Interface JPA para persistência;
controller → Endpoints REST;
Application → Classe principal com configuração Spring Boot

⚙️ Exemplo de Endpoint
GET /enquetes;
POST /enquetes;
PUT /enquetes/{id};
DELETE /enquetes/{id}

🎯 Objetivo do Projeto

Desenvolver uma API REST funcional para prática de back-end com Spring Boot, explorando persistência de dados, relacionamento entre entidades e boas práticas de arquitetura web.

💡 Diferencial
Este projeto demonstra:
Desenvolvimento de API REST completa;
Uso de framework profissional amplamente utilizado no mercado;
Organização em camadas;
Persistência com banco de dados;
Estrutura preparada para expansão
