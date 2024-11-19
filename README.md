# CRUD USER - ADDRESS
O projeto se trata de uma API que cadastra usuários e endereços em um banco de dados MySql.

usei o seguinte repositororio como base a base da arquitetura limpa:
[quarkus clean arch base - Sandro Ramos](https://github.com/Sandrolaxx/quarkus-clean-arch-base)
A API foi desenvolvida usando JDK 17, Quarkus, arquitetura limpa, API RESTful e banco de dados relacional MySql.

Para subir o projeto, primeiro rode o seguinte comando, para subir o container com o banco de dados:
```
docker compose up -d 
```
Em seguida, inicie o modo desenvolvimento do quarkus:
```
./mnvwn quarkus:dev
```
Após isso, os endpoints de CRUD para USER e ADDRESS estarão funcionando.
Elas estão localizadas em src/main/java/com/kraemer/presentation/controllers


