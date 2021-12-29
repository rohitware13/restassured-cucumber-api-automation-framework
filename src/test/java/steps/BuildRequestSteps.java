package steps;

import com.typesafe.config.Config;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigProvider;

public class BuildRequestSteps {

    Logger log = LoggerFactory.getLogger(BuildRequestSteps.class);

    public static RequestSpecification requestSpecification;

    @Given("the user wants to make {string} api call")
    public void theUserWantsToMakeApiCall(String apiCall) {
        log.info("Making " + apiCall.toUpperCase() + " API Call");

        Config config = ConfigProvider.config();
        RestAssured.baseURI = config.getConfig("api").getString("baseURI");

        requestSpecification = RestAssured.given();
        requestSpecification.headers(config.getObject("headers").unwrapped());
        requestSpecification.log().all().expect().log().all();
    }
}
