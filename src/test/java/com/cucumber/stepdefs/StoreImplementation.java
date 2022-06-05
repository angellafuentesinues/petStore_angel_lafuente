
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

public class StoreImplementation implements Serializable {

    private Response putStore = null;
    private Response postStore = null;
    private Response deleteStore = null;
    Response responseDeleteOrder = null;
    @Before
    public void before() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

    }

    @Given("the following get request that brings us a purchase order")
    public Response getStore() {

        Response responseGetStore = given().log().all().get("store/order/4");

        return responseGetStore;
    }




    @Given("the following post request that add a new order")
    public void postNewOrder() {

        File bodyRequestOrder = new File("src/main/resources/bodyRequestPostStoreOrder.json");
        given().contentType(ContentType.JSON).body(bodyRequestOrder).post("store/order");

    }

    @And("the response is 200 for the postOrder")
    public void validateResponsePostOrder() {
        assertTrue("The response is not 200", postStore.statusCode()==200);
    }

    @Given("the following get request that returns us statusCode")
    public Response getStatusCodes() {

        Response responseGetStatusCodes = given().log().all().get("store/inventory");

        return responseGetStatusCodes;
    }

    @Given("the next delete that erase an order")
    public void deleteOrder() {
        responseDeleteOrder = given().log().all().delete("store/order/4");
    }

    @And("the response is 200 for the erase")
    public void validateResponseErase() {
        assertTrue("The response is not 200", responseDeleteOrder.statusCode() == 200);
    }


}