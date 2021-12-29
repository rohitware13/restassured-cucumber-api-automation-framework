package steps;


import constants.APIEndPoints;
import constants.APIProperties;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.JsonReader;

public class UpdateUserSteps {

    Logger log = LoggerFactory.getLogger(UpdateUserSteps.class);

    RequestSpecification requestSpecification = BuildRequestSteps.requestSpecification;
    Response response;
    JsonPath jsonPathEvaluator;

    @When("the user sends the request with payload to update")
    public void theUserSendsTheRequestWithPayloadToUpdate() {
        log.info("Making a request with Payload to update");

        requestSpecification = requestSpecification.body(JsonReader.getJson(APIProperties.UPDATE_USER_PAYLOAD));
        response = requestSpecification.put(APIEndPoints.UPDATE_USER);
        StatusSteps.response = response;
    }

    @Then("the user data is updates successfully")
    public void theUserDataIsUpdatesSuccessfully() {
        log.info("Verifying response data");

        jsonPathEvaluator = response.jsonPath();
        Assert.assertTrue("Data is NOT updated",
                jsonPathEvaluator.get("name").equals(JsonReader.getValueFromResponse("name", APIProperties.UPDATE_USER_PAYLOAD)));
    }


}
