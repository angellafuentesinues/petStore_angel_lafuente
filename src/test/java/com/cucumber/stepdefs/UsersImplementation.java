
package com.cucumber.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.io.Serializable;

import static io.restassured.RestAssured.given;

public class UsersImplementation implements Serializable {

    private Response putUsers = null;
    private Response postUsers = null;
    private Response deleteUsers = null;

    @Before
    public void before() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";

    }

    @Given("the next get request that brings us the users")
    public Response getUsers() {

        Response responseGetUsers = given().log().all().get("user/sting");
        return responseGetUsers;
    }

//    @And("the respon is 200")
//    public void validateResponse() {
//        System.out.println(getUsers().statusCode());
//        assertTrue("The response is not 200", getUsers().statusCode() == 200);
//    }

    @Given("the following post request that add a new user")
    public void postUser() {

        File bodyRequestUser = new File("src/main/resources/bodyRequestPostUser.json");
        given().contentType(ContentType.JSON).body(bodyRequestUser).post("user/createWithList");

    }

//    @And("the response is 200 for the new user")
//    public void validateResponseAddPost() {
//        assertTrue("The response is not 200", postUsers.statusCode() == 200);
//    }




//    @And("the response is 200 for the post")
//    public void validateResponsePost(){
//        System.out.println(getUsers().statusCode());
//        assertTrue( "The response is not 200",postUsers.statusCode()==200);
//
//    }

    @Given("the next put request that update an user")
    public void putUpdateUser() {

        File bodyRequestUser = new File("src/main/resources/updateRequestPutUser.json");
        given().contentType(ContentType.JSON).body(bodyRequestUser).put("user/sting");

    }

//    @userDelete("the next delete request that erase an user")
//    public Response deleteUsers() {
//
//        Response responseDeleteUsers = given().log().all().get("user/Mister");
//        return responseDeleteUsers;
//    }
}


//    @Given("the following post request that add users")
//    public void postUsers()
//            {

//        HashMap<String, String> bodyRequestMap = new HashMap<>();
//        bodyRequestMap.put("id", "4444");
//        bodyRequestMap.put("username", "sting");
//        bodyRequestMap.put("firstname", "antonio");
//        bodyRequestMap.put("lastname", "jesus");
//        bodyRequestMap.put("email", "mail1@mail.com");
//        bodyRequestMap.put("password","user1");
//        bodyRequestMap.put("phone", "555555555");
//        bodyRequestMap.put("userStatus", "4" );
//                postUsers =
//                        given().contentType(ContentType.JSON).body(bodyRequestMap).post("user/createWithList");
//            }


//    @And("the response is 201 for the post")
//    public void validateResponsePost() {
//        assertTrue("The response is not 201", postUsers.statusCode() == 201);
//    }
//
//    @And("the body response contains key name")
//    public void validateResponsePostKeyBody() {
//        postUsers.then().body("$", hasKey("id"));
//    }
//
//    @Then("the body response contains the {string} of the user created")
//    public void validateResponsePostBodyValueName(String valueName) {
//        JsonPath jsonPathUsers = new JsonPath(postUsers.body().asString());
//        String jsonUsers = jsonPathUsers.getString("name");
//        assertEquals("The value of the name field is not what is expected", valueName, jsonUsers);
//    }
//
//    @And("the response is 200 for the put")
//    public void validateResponsePut() {
//        assertTrue("The response is not 200",putUsers.statusCode()==200);
//    }
//
//
//    @Then("the body response contains update {string}")
//    public void validateResponsePutBodyUpdatedValueName(String updatedName) {
//        JsonPath jsonPathUsers = new JsonPath(putUsers.body().asString());
//        String jsonUserName = jsonPathUsers.getString("name");
//        assertEquals("The value of the name field is not what is expected", updatedName, jsonUserName);
//    }


//}