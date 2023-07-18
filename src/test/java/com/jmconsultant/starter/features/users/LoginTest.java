package com.jmconsultant.starter.features.users;

import com.jmconsultant.starter.conf.BaseTest;
import com.jmconsultant.starter.enums.UserStatus;
import com.jmconsultant.starter.factories.LoginFactory;
import com.jmconsultant.starter.models.users.UsersResponse;
import com.jmconsultant.starter.questions.AllUsers;
import com.jmconsultant.starter.tasks.GetAllUsers;
import com.jmconsultant.starter.tasks.Login;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.TestsRequirement;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

@ExtendWith(SerenityJUnit5Extension.class)
@Narrative(text = {"As a user",
        "I want to be able to ..",
        "in order to ..."})
@DisplayName("Login feature")
public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Get all the users registered from displayed name")
    @Tag("mock")
    void loginWithValidCredentials() {

        actor.attemptsTo(
                Login
                        .with(LoginFactory.withValidUser())
        );

        Ensure.that(SerenityRest.lastResponse().statusCode())
                .isEqualTo(HttpStatus.SC_OK);

    }
}
