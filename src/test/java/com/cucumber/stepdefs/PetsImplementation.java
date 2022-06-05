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

public class PetsImplementation implements Serializable {

    private Response putPets = null;
    private Response postPets = null;
    private Response deletePets = null;
    Response responseDeletePets = null;

    @Before
    public void before() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";

    }

//    @Given("the following get request that brings us the pets")
//    public Response getPets() {
//
//        Response responseGetPets = given().log().all().get("pet/findByStatus?status=available,pending,sold");
//        return responseGetPets;
//    }
//
//    @And("the response is 200")
//    public void validateResponse() {
//        assertTrue("The response is not 200", getPets().statusCode()==200);
//
//    }


    @Given("the following get request that add a new pet")
    public void postNewPet() {

        File bodyRequestPet = new File("src/main/resources/bodyRequestPostPet.json");
        given().contentType(ContentType.JSON).body(bodyRequestPet).post("pet");

    }
    @And("the response is 200 for the post")
    public void validateResponsePost() {
        assertTrue("The response is not 200", postPets.statusCode() == 200);
    }




    @Given("the following get request that find a pet by ID")
    public Response getPets() {

        Response responseGetPet = given().log().all().get("pet/4444");
        return responseGetPet;
    }

    @And("the response is 200")
    public void validateResponse() {
        assertTrue("The response is not 200", getPets().statusCode() == 200);

    }





//    @And("the body response contains key name")
//    public void validateResponsePostKeyBody() {
//        postPets.then().body("$", hasKey("id"));
//    }
//
//    @Then("the body response contains the {string} of the user created")
//    public void validateResponsePostBodyValueName(String valueName) {
//        JsonPath jsonPathUsers = new JsonPath(postPets.body().asString());
//        String jsonUsers = jsonPathUsers.getString("name");
//        assertEquals("The value of the name field is not what is expected", valueName, jsonUsers);
//    }
//
//    @And("the response is 200 for the put")
//    public void validateResponsePut() {
//        assertEquals("The response is not 200", 200, putPets.statusCode());
//    }
//
//
//    @Then("the body response contains update {string}")
//    public void validateResponsePutBodyUpdatedValueName(String updatedName) {
//        JsonPath jsonPathUsers = new JsonPath(putPets.body().asString());
//        String jsonUserName = jsonPathUsers.getString("name");
//        assertEquals("The value of the name field is not what is expected", updatedName, jsonUserName);
//    }

    @Given("the next put request that update a pet")
    public void putPet() {
        File bodyRequestPet = new File("src/main/resources/updateRequestPutPet.json");
        given().contentType(ContentType.JSON).body(bodyRequestPet).put("pet");
    }

    @And("the response is 200 for the put")
    public void validateResponsePut() {
        assertTrue("The response is not 200", putPets.statusCode() == 200);
    }

//    @Given("the following delete that erase a pet")
//    public Response deleteUsers() {

//        Response responseDeletePets = given().log().all().delete("pet/4444");
//        return responseDeletePets;
//    }

    @Given("the following delete that erase a pet")
    public void deletePets() {
        responseDeletePets = given().log().all().delete("/pet/4444");
    }

    @And("the response is 200 for the delete")
    public void validateResponseDelete() {
        assertTrue("The response is not 200", responseDeletePets.statusCode() == 200);
    }


//    @Then("the body response is empty")
//    public void validateResponseDelete() {
//        assertTrue("The value of the name field is not what is expected",
//                deletePets.body().asString().isEmpty());
//    }


}


//package com.cucumber.stepdefs;
//
//import io.cucumber.java.Before;
//import io.cucumber.java.en.Given;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//
//import java.io.File;
//import java.io.Serializable;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.hasKey;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//public class PetsImplementation implements Serializable {
//
//    private Response putPets = null;
//    private Response postPets = null;
//    private Response deletePets = null;
//
//    @Before
//    public void before() {
//        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
//
//        }
//
//    @Given("the following get request that brings us the pets")
//    public Response getPets() {
//
//        Response responseGetPets = given().log().all().get("pet/4444");
//        return responseGetPets;
//    }
//
//    @Given("the following get request that add a new pet")
//    public void postNewPet() {
//
//        File bodyRequestPet=new File("src/main/resources/bodyRequestPostPet.json");
//        given().contentType(ContentType.JSON).body(bodyRequestPet).post("/pet");
//
//    }
//
//    @Given("the next put request that update a pet")
//    public void putUpdatePet() {
//
//        File bodyRequestPet=new File("src/main/resources/updateRequestPutPet.json");
//        given().contentType(ContentType.JSON).body(bodyRequestPet).post("/pet");
//
//
//    }
//
//}
//
//
