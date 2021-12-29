package steps;

import constants.APIEndPoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserListSteps {

    Logger log = LoggerFactory.getLogger(UserListSteps.class);

    RequestSpecification requestSpecification = BuildRequestSteps.requestSpecification;
    Response response;

    @When("the user sends the request with valid parameter")
    public void theUserSendsTheRequestWithValidParameter() {
        log.info("Making a Get API call");

        response = requestSpecification.get(APIEndPoints.LIST_USERS);
        StatusSteps.response = response;
    }

}
