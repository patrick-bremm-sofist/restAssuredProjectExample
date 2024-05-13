package ToolsQA;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class EmployeesTest {
    // API Utilizada
    // https://automationexercise.com/api_list

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://automationexercise.com/api";
        RestAssured.port = 443;
        RestAssured.registerParser("text/html", Parser.JSON); // Translate the response text to json
    }

    @Test
    @DisplayName("List all products")
    public void testListAllProducts() throws InterruptedException {
        Response response = given()
            .contentType(ContentType.JSON)
            .when()
                .get("productsList")
            .then()
                .statusCode(200)
                .assertThat()
                    .body("responseCode", equalTo(200))
                    .body("products.name", hasItems("Blue Top", "Madame Top For Women"))
                .log().all()
                .extract().response();
    }
}
