package com.jmconsultant.starter.tasks;

import com.jmconsultant.starter.endpoints.EndPoints;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetAllUsers implements Task {

    public static Performable registered() {
        return instrumented(GetAllUsers.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(EndPoints.GET_ALL_USERS.path())
                        .with(request -> request
                                .contentType(ContentType.JSON)
                        ));
    }
}
