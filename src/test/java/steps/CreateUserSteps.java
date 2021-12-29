package steps;

import constants.APIEndPoints;
import constants.APIProperties;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.JsonReader;

public class CreateUserSteps {
    Logger log = LoggerFactory.getLogger(CreateUserSteps.class);

    RequestSpecification requestSpecification = BuildRequestSteps.requestSpecification;
    Response response;

    @When("the user sends the request with payload")
    public void theUserSendsTheRequestWithPayload() {
        log.info("Making a request with Payload");

        requestSpecification = requestSpecification.body(JsonReader.getJson(APIProperties.CREATE_USER_PAYLOAD));
        response = requestSpecification.post(APIEndPoints.CREATE_USER);
        StatusSteps.response = response;
    }

    @Then("the user id should be return as response")
    public void theUserIdShouldBeReturnAsResponse() {
        log.info("Verifying response");
        Assert.assertTrue(response.asString().contains("id"));
    }
}
