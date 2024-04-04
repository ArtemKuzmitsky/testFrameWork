package api.requests;

import api.ApiTestConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.FootballEndPoints;
import io.qameta.allure.Step;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ApiRequests extends ApiTestConfig {
    @Step("GET all areas")
    public Response getAllAreas() {
        ExtractableResponse<Response> response = given()
                .when()
                .get(FootballEndPoints.AREAS_ENDPOINT)
                .then()
                // .body(matchesJsonSchemaInClasspath("jsonSchemaToCheck.json"))
                .extract();
        return response.response();
    }

    @Step("GET area with param {0}")
    public Response getArea(String param) {
        ExtractableResponse<Response> response = given()
                .pathParam("areaId", param)
                //.queryParam("areaId",param)
                .when()
                .get(FootballEndPoints.AREA_ENDPOINT)
                .then()
                .extract();
        return response.response();
    }

    @Step("Post area with body {0}")
    public Response dummyPostReq(Object body) {
        ObjectMapper objectMapper = new ObjectMapper();
        String request = null;
        try {
            request = objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        ExtractableResponse<Response> response = given()
                .body(request)
                .when()
                .post(FootballEndPoints.POST_ENDPOINT)
                .then()
                .extract();
        return response.response();
    }

}
