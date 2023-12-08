package com.stepDefinitions;

import java.util.Map;

import com.base.TestBase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swaroop.utils.TestContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import pojoClasses.CreateStore;

import static io.restassured.RestAssured.*;

public class CreateStoreStepDefinitions extends TestBase{
	
	CreateStore requestBody = new CreateStore();
	
	
	
	@And("the request body is created")
	public void the_request_body_is_created_with_the_following_data(DataTable dataTable) {
	    Map<String, String> requestBodyFields = dataTable.asMaps().get(0);
	    
	    requestBody.setName(requestBodyFields.get("name"));
	    requestBody.setType(requestBodyFields.get("type"));
	    requestBody.setAddress(requestBodyFields.get("address"));
	    requestBody.setCity(requestBodyFields.get("city"));
	    requestBody.setState(requestBodyFields.get("state"));
	    requestBody.setZip(requestBodyFields.get("zip"));
	}

	@When("the api is invoked using Post Method")
	public void the_api_is_invoked_using_post_method() throws JsonProcessingException {
	    ObjectMapper objectMapper = new ObjectMapper();
	    String requestBodyString = objectMapper.writeValueAsString(requestBody);
	    response = given().body(requestBodyString).contentType(ContentType.JSON).log().all()
	    .when().post("/stores");
	    context.setResponse(response);
	}

	@And("the response body should have a value in the store id field")
	public void the_response_body_should_have_a_value_in_the_store_id_field() {
		Assert.assertNotNull(context.getResponse().body().jsonPath().getInt("id"));
	}

}
