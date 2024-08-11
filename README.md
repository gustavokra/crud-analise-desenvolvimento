# CRUD USER - ADDRESS
O projeto se trata de uma API que cadastra usuários e endereços em um banco de dados MySql.

A API feita usando Quarkus, arquitetura limpa, API RESTful e banco de dados relacional MySql.

Para subir o projeto, primeiro rode o seguinte comando, para subir o container com o banco de dados:
```
docker compose up -d 
```
Em seguida, inicie o modo desenvolvimento do quarkus:
```
./mnvwn quarkus:dev
```
Após isso, as os endpoints de CRUD para USER e ADDRESS estarão funcionando.
Elas estão localizadas em src/main/java/com/kraemer/presentation/controllers


