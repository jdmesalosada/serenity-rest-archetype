package com.jmconsultant.starter.tasks;

import com.jmconsultant.starter.endpoints.EndPoints;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetSingleUser implements Task {

    private final int id;

    public GetSingleUser(int id){
        this.id = id;
    }

    public static Performable byId(int id) {
        return instrumented(GetSingleUser.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(EndPoints.GET_SINGLE_USER.path())
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .pathParam("user_id", id
                        )));
    }
}
