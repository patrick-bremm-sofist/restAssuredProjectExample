package ToolsQA;

import org.junit.jupiter.api.BeforeAll;

import ToolsQA.readProperties.ReadApiProperties;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

public class BaseTest {
    @BeforeAll
    public static void setup() throws Exception {
        ReadApiProperties readApiProperties = new ReadApiProperties();
        RestAssured.baseURI = readApiProperties.get("baseUri");
        RestAssured.port = Integer.parseInt(readApiProperties.get("port"));
        RestAssured.registerParser("text/html", Parser.JSON); // Translate the response text to json
    }
}
