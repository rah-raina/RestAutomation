package com.bdd.app.definitions;



import com.bdd.app.definitions.steps.RestAPISteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Steps;

public class RestAPIDefinitions {

	@Steps
	RestAPISteps restSteps;

	@Given("set base uri of application '(.*)'")
	public void givenURI(String baseURI) {
		restSteps.setBaseURI(baseURI);
	}

	@When("perform get operation for '(.*)'")
	public void whenGetOperation(String serviceUri) {
		restSteps.performGetOperation(serviceUri);
	}

	@Then("verify response code '(.*)'")
	public void thenVerifyResponseCode(int code) {
		restSteps.verifyResponseCode(code);
	}
	
	@Then("verify response body contains:")
	public void verify_response_vody_contains(DataTable dataTable) {
		restSteps.verifyResponseBody(dataTable);
	}
	
	@When("perform get operation for '(.*)' along with query paramters:")
	public void whenGetOperation(String serviceUri,DataTable dataTable) {
		restSteps.performGetOperation(serviceUri,dataTable);
	}
	
	@When("perform post operation for '(.*)' with payload as '(.*)'")
	public void whenPostOperation(String serviceUri,String path) {
		restSteps.performPostOperation(serviceUri,path);
	}
}
