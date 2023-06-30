package starter.actors;

import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;

import net.serenitybdd.screenplay.actors.Cast;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.config.RestAssuredConfig;
import io.restassured.parsing.Parser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import starter.conf.TestEnvironment;

public class CastOfUsers extends Cast {
    private final TestEnvironment testEnvironment;

    public CastOfUsers(EnvironmentVariables environmentVariables) {
        testEnvironment = new TestEnvironment(environmentVariables);
    }
    @Override
    public Actor actorNamed(String actorName, Ability... abilities) {
        SerenityRest.setDefaultConfig(restAssuredConfig());
        SerenityRest.setDefaultParser(Parser.JSON);

        Actor user = super.actorNamed(actorName, abilities);
        SerenityRest.useRelaxedHTTPSValidation();
        user.can(CallAnApi.at(testEnvironment.getRestAPIBaseUrl()));

        return user;
    }
    private RestAssuredConfig restAssuredConfig() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return config().objectMapperConfig(
                objectMapperConfig().jackson2ObjectMapperFactory((cls, charset) -> objectMapper));
    }
}
