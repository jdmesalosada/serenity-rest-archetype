package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.http.HttpStatus;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class SearchUsersStepDefinitions {

    @Given("{actor} is the marketing director")
    public void sergey_is_the_marketing_director(Actor actor) {

    }
    @When("{actor} asks for all the clients registered")
    public void he_asks_for_all_the_clients_registered(Actor actor) {

        actor.attemptsTo(
                Get.resource("/api/users")
        );

    }
    @Then("{actor} should see all the clients registered")
    public void he_should_see_all_the_clients_registered(Actor actor) {
        actor.should(
                seeThat("fail to get all users", act -> SerenityRest.lastResponse().statusCode(),
                        equalTo(HttpStatus.SC_OK))
        );
    }
}
