package api.requests;

import api.ApiTestConfig;
import config.FootballEndPoints;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class ApiRequests extends ApiTestConfig {

    public Response getAllAreas(){
        ExtractableResponse<Response> response = given()
                .when()
                .get(FootballEndPoints.AREAS_ENDPOINT)
                .then()
               // .body(matchesJsonSchemaInClasspath("jsonSchemaToCheck.json"))
                .extract();
        return response.response();
    }

    public Response getArea(String param){
        ExtractableResponse<Response> response = given()
                .pathParam("areaId",param)
                //.queryParam("areaId",param)
                .when()
                .get(FootballEndPoints.AREA_ENDPOINT)
                .then()
                .extract();
        return response.response();
    }

    public Response dummyPostReq(String body){
        ExtractableResponse<Response> response = given()
                .body(body)
                .when()
                .post(FootballEndPoints.POST_ENDPOINT)
                .then()
                .extract();
        return response.response();
    }

}
