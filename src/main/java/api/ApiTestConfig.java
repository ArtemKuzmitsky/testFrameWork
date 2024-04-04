package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import utils.PropertiesReader;
import utils.TestConfigProperties;

public class ApiTestConfig {
    static TestConfigProperties configProperties = PropertiesReader.getTestConfigProperties();

    public static void setUp() {

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(configProperties.baseURL())
                .setBasePath(configProperties.basePath())
                .addHeader("X-Auth-Token", "a5b55f05b6724d3b98a55ecb9de27627")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).build();
    }
}
