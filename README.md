# 🧠 API - Sistema de Loja Online (Back-End)

Este é o back-end do sistema de loja online desenvolvido com Java e Spring Boot, utilizando Maven como gerenciador de dependências. Ele oferece endpoints RESTful para gerenciamento de produtos, clientes e pedidos.

📋 Funcionalidades da API

✅ Criar produto

✏️ Editar produto

❌ Remover (soft delete) produto

🔍 Listar produtos com filtros e paginação

📌 Gerenciar clientes

📁 Estrutura do Projeto
```
src/
├── main/
│   └── java/
│       └── onlineshop/
│           ├── controller/
|           ├── dto/
|           ├── exception/
│           ├── model/
│           ├── repository/
│           ├── service/
│           └── OnlineShopApplication.java
├── resources/
│   ├── application.properties
└── test/
```
🧪 Endpoints disponíveis
```
# Produtos
POST    /products                  -> Criar novo produto
PUT     /products/{id}             -> Editar produto existente
DELETE  /products/{id}             -> Remover produto (soft delete)
GET     /products?page=1&size=10   -> Listar produtos com filtros e paginação
GET     /products/{id}             -> Obter produto por ID

# Clientes
POST    /clients                   -> Criar cliente
PUT     /clients/{id}              -> Atualizar cliente
DELETE  /clients/{id}              -> Remover cliente
GET     /clients?page=1&size=10    -> Listar clientes com filtros e paginação
GET     /clients/{id}              -> Obter cliente por ID
```
```
DB_URL=jdbc:mysql://localhost:3306/onlineshop
DB_USER=usuario
DB_PASSWORD=sua_senha
SPRING_PROFILES_ACTIVE=dev
```
🚀 Como rodar o projeto localmente
```
1. Clone o repositório
git clone https://github.com/FelipeSalazar1/OnlineShop-API.git
cd OnlineShop-API

2. Execute o projeto com Maven
./mvnw spring-boot:run
ou, se estiver usando Windows:
mvnw.cmd spring-boot:run
```
🙋‍♂️ Autores
| NOME              | RM |
|----------------|----------------|
|MARCELO VIEIRA DE MELO|RM552953|
|FELIPE CASTRO SALAZAR|RM553464|
|VICTOR RODRIGUES|RM554158|
|RAYARA AMARO FIGUEIREDO|RM552635|
|ERICK MOLINA|RM553852|
