package ToolsQA;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class ApiTest {
    // API Utilizada
    // https://automationexercise.com/api_list

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/";
        RestAssured.port = 443;
    }

    @Test
    public void testListAllEmployees() {        
        Response response = given()
            .header("Content-Type", "application/json")
            .when()
                .get("employees")
            .then()
                .statusCode(200)
                .assertThat()
                    .body("status", equalTo("success"))
                    .body("data.id", hasItems(1, 2))
                .log().all()
                .extract().response();
    }

    @Test
    public void testGetEmployees() {
        Response response = given()
        .header("Content-Type", "application/json")
        .when()
            .get("employee/1")
        .then()
            .statusCode(200)
            .assertThat()
                .body("status", equalTo("success"))
                .body("data.id", equalTo(1))
            .log().all()
            .extract().response();
    }
}
