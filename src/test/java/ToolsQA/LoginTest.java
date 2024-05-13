package ToolsQA;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class LoginTest {
    
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://automationexercise.com/api";
        RestAssured.port = 443;
        RestAssured.registerParser("text/html", Parser.JSON); // Translate the response text to json
    }
    
    @Test
    @DisplayName("Verify login with invalid user")
    public void testVerifyLoginWithInvalidUser() throws InterruptedException {
        Response response = given()
            .contentType(ContentType.MULTIPART)
            .multiPart("email", "email")
            .multiPart("password", "123")
            .when()
                .post("verifyLogin")
            .then()
                .statusCode(200)
                .assertThat()
                    .body("responseCode", equalTo(404))
                    .body("message", equalTo("User not found!"))
                .log().all()
                .extract().response();
    }
}
