package steps;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatusSteps {

    Logger log = LoggerFactory.getLogger(StatusSteps.class);

    public static Response response;

    @Then("the response code is success 200")
    public void theResponseCodeIsSuccess() {
        log.info("Verifying Status Code as 200 OK");
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Then("the response code is created 201")
    public void theResponseCodeIsCreated() {
        log.info("Verifying Status Code as 201 Created");
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
    }
}
