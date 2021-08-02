package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static stepdefinitions.InitializeTest.elementIds;
import static stepdefinitions.LocatorMethods.elementLocator;

public class RestfulAPITest {

	@Given("Test user is created")
	public void testCustomerCreated() {
		RestAssured.baseURI = "https://url.com";
		given().urlEncodingEnabled(true)
				.param("param1", "value1")
				.param("param2", "value2")
				.param("param3", "value3")
				.param("param4", "value4")

				.header("Accept", ContentType.JSON.getAcceptHeader())
				.post("/v1/path")
				.then().statusCode(200);
		int a  = get().statusCode();
		System.out.println(a);


	}

	@Then("{string} should match with the {string} in {string}")
	public void shouldMatchWithTheBackend(String element, String field, String service) {
		//Get customer key from properties file

		String custkey = elementIds.getProperty("KEY");
		String subkey = elementIds.getProperty("KEY");

		//Get API service URL from properties file based on the service type
		RestAssured.baseURI = elementIds.getProperty(service);

		// Get the RequestSpecification of the request that you want to sent
		RequestSpecification httpRequest = RestAssured.given();

		//Specify API request URL and send
		Response response = null;
		switch (service) {
			case "API1":
				response = httpRequest.get(custkey);
				break;
			case "API2":
				response = httpRequest.get(subkey);
				break;
			case "API3":
				response = httpRequest.get(subkey + "?from=2021-01-01&to=2021-01-15");
				break;
		}
		//Print whole JSON response
		System.out.println("Response Body is =>  " + response.asString());
		JsonPath jsonPathEvaluator = response.jsonPath();

		//Define which part of the JSON file you want to get and print
		String accountDb = jsonPathEvaluator.get(field);
		System.out.println("customer number in db is :" + accountDb);

		//Get text from frontend element
		String accountFront = elementLocator(element).getText();
		System.out.println("customer in frontend is :" + accountFront);

		//Assert
		Assert.assertEquals(accountDb, accountFront);


	}




}