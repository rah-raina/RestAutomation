package com.bdd.app.definitions.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdd.app.pages.RestAPIPage;

import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

@SuppressWarnings("serial")
public class RestAPISteps extends ScenarioSteps {
	
	RestAPIPage restAPIPage = new RestAPIPage();

   @Step
   public void setBaseURI(String uri) {
	   restAPIPage.setBaseURI(uri);
   }
   
   @Step
   public void performGetOperarition(String serviceUri) {
	   
	   Map<String,String> headers = new HashMap<String,String>();
	   Map<String,String> queryParam = new HashMap<String,String>();
	   Map<String,String> pathParam = new HashMap<String,String>();
	   
	   restAPIPage.getRestRequest(serviceUri,headers,queryParam,pathParam);
   }
   
   @Step
   public void verifyResponseCode(int code) {
	   
	   assertTrue("Response code mismatch", restAPIPage.getResponseCode() == code);
   }

public void verifyResponseBody(DataTable dataTable) {
	// TODO Auto-generated method stub
	Map<String,String> valueToVerify = dataTable.asMap(String.class, String.class);
	
	List<String> listJsonPath = new ArrayList<String>(valueToVerify.keySet());
	
	Map<String,String> retreiveValues = restAPIPage.parseListOfJsonPathToValues(listJsonPath);
	
	for(String path : retreiveValues.keySet()) {
		assertEquals("Data mismatch", valueToVerify.get(path), retreiveValues.get(path));
	}
	
	
	
	
}
}
