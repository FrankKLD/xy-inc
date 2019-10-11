# Projeto - Backend Zup

Backend desenvolvido em Java 8 com os seguintes endpoints:
```
GET    /products        - Lista todos os produtos 
GET    /products/{id}   - Busca um produto por id 
POST   /products        - Cria um novo produto 
PUT    /products/{id}   - Edita um produto 
DELETE /products/{id}   - Deleta um produto 
```

## Getting Started

Basta executar como um projeto SpringBoot normal.

### Pré requisitos
Pré requisitos para funcionamento normal do Backend:
```
Necessário ter Java 8 instalado;
Banco de Dados PostgreSQL 10;
```

### Instalação

Antes de rodar a Aplicação, será necessário criar o Banco de dados 
com os scripts abaixo:


```
CREATE DATABASE "ZUPDB"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
```
```
CREATE TABLE public.product
(
    id_product bigint NOT NULL,
    name character varying(50) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    price numeric(8,2),
    category character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT product_pkey PRIMARY KEY (id_product)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.product
    OWNER to postgres;
```

Após a criação do Banco de Dados, basta executar a aplicação.
## Testes

Testando o método POST (Criar um novo Produto):
```
http://localhost:8080/products

- Passar este json no Body:

   {
        "name": "Arroz",
        "description": "Arroz Integral",
        "price": 3.65,
        "category": "Nao perecivel"
   }
```
Testando o método GET (Listar Todos os Produtos):
```
http://localhost:8080/products
```
Testando o método GET passando id do Produto(Pesquisar Produto por ID):
```
http://localhost:8080/products/1
```
Testando o método PUT (Editar um Produto):
```
http://localhost:8080/products

- Passar este json no Body:

   {
        "idProduct": 1,
        "name": "Arroz ALTERADO",
        "description": "Arroz Integral ALTERADO",
        "price": 3.70,
        "category": "Nao perecivel"
   }
```
Testando o método DELETE (Deletar um Produto):
```
http://localhost:8080/products

- Passar este json no Body:

   {
        "idProduct": 1,
        "name": "Arroz ALTERADO",
        "description": "Arroz Integral ALTERADO",
        "price": 3.70,
        "category": "Nao perecivel"
   }
```