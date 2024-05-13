package ToolsQA;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ToolsQA.readProperties.ReadDataTestProperties;
import ToolsQA.readProperties.ReadMessageTestProperties;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class LoginTest extends BaseTest {
    // API Utilizada
    // https://automationexercise.com/api_list
        
    @Test
    @DisplayName("Verify login with invalid user")
    public void testVerifyLoginWithInvalidUser() throws Exception {
        ReadDataTestProperties data = new ReadDataTestProperties();
        ReadMessageTestProperties msg = new ReadMessageTestProperties();
        Response response = given()
            .contentType(ContentType.MULTIPART)
            .multiPart("email", data.get("email"))
            .multiPart("password", data.get("password"))
            .when()
                .post("verifyLogin")
            .then()
                .statusCode(200)
                .assertThat()
                    .body("responseCode", equalTo(404))
                    .body("message", equalTo(msg.get("userNotFound")))
                .log().all()
                .extract().response();
    }
}
