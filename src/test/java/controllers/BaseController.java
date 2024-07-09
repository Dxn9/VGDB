package controllers;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static constants.Constant.BASE_URI;

public class BaseController {

    protected RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .addHeader("Accept", "application/json")
            .log(LogDetail.ALL)
            .build();

    protected ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    protected Response makeGetRequest(String path) {
        return RestAssured.given()
                .spec(requestSpecification)
                .when()
                .get(path)
                .then()
                .spec(responseSpecification)
                .extract().response();
    }

    protected Response makePostRequest(String path, Object body) {
        return RestAssured.given()
                .spec(requestSpecification)
                .body(body)
                .when()
                .post(path)
                .then()
                .spec(responseSpecification)
                .extract().response();
    }

    protected Response makePutRequest(String path, Object body) {
        return RestAssured.given()
                .spec(requestSpecification)
                .body(body)
                .when()
                .put(path)
                .then()
                .spec(responseSpecification)
                .extract().response();
    }

    protected Response makeDeleteRequest(String path) {
        return RestAssured.given()
                .spec(requestSpecification)
                .when()
                .delete(path)
                .then()
                .spec(responseSpecification)
                .extract().response();
    }
}
