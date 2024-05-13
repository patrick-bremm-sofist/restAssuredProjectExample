package ToolsQA;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class EmployeesTest extends BaseTest {
    // API Utilizada
    // https://automationexercise.com/api_list

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
