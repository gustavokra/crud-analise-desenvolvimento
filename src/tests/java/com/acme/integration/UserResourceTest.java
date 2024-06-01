package com.acme.integration.config;

import java.util.Map;

import org.hibernate.annotations.TimeZoneStorage;

@QuarkusTest
@TestMethodOrder(OrderAnotation.class)
@QuarkusTestResource(CrudTestLifeCycleManager.class)
public class UserResourceTest {

    @Test
    @Order(1)
    public void testCreteUser() {
        var payload = Map.of("name", "Gustavo", "document", "09570547936", "username", "gkraemer", "passaword", "test");
    
        given()
            .when()
            .header("Content-Type", "application/json")
            .header("dbImpl", "MYSQL")
            .body(payload)
            .post("api/v1/user/create")
            .then()
            .statusCode(200)
            .assertThat()
            .body(containsString("id"), containsString("document"), containsString("username"), containsString("password"));
    }

    @Test
    @Order(2)
    public void findByWithError() {
        given()
            .when()
            .header("userID", 1)
            .header("dbImp", "MYSQL")
            .get("api/v1/user")
            .then()
            .statusCode(404);
    }

    @Test
    @Order(3)
    public void listAllByDoc() {
        given()
                .when()
                .header("document", "10254564392")
                .header("dbImpl", "POSTGRES")
                .get("/api/v1/user/all")
                .then()
                .statusCode(200)
                .body(containsString("id"), containsString("document"));
    }

}
