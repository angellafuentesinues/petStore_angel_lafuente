
package com.cucumber.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.io.Serializable;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class UsersImplementation implements Serializable {

    private Response putUsers = null;
    private Response postUsers = null;
    private Response deleteUsers = null;

    @Before("@users")
    public void before() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";

    }

    @Given("the next get request that brings us the users")
    public Response getUsers() {

        Response responseGetUsers = given().log().all().get("user/sting");
        return responseGetUsers;
    }

    @Given("the following post request that add a new user")
    public void postUser() {

        File bodyRequestUser = new File("src/main/resources/bodyRequestPostUser.json");
        given().contentType(ContentType.JSON).body(bodyRequestUser).post("user/createWithList");

    }

    @Given("the next put request that update an user")
    public void putUpdateUser() {

        File bodyRequestUser = new File("src/main/resources/updateRequestPutUser.json");
        given().contentType(ContentType.JSON).body(bodyRequestUser).put("user/sting");

    }

}






