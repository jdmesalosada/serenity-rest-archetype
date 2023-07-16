package com.jmconsultant.starter.facts;

import com.google.gson.GsonBuilder;
import com.jmconsultant.starter.models.register.UserRegisterRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.jmconsultant.starter.endpoints.EndPoints.REGISTER_USER;

public class AnUserRegistered implements Fact {

    private final UserRegisterRequest userRegisterRequest;

    public AnUserRegistered(UserRegisterRequest userRegisterRequest) {
        this.userRegisterRequest = userRegisterRequest;
    }

    public static AnUserRegistered withInfo(UserRegisterRequest userRegisterRequest) {
        return new AnUserRegistered(userRegisterRequest);
    }

    @Override
    public void setup(Actor actor) {
        actor.attemptsTo(
                Post.to(REGISTER_USER.path())
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .body(this.userRegisterRequest)
                        )
        );
    }

    @Override
    public String toString() {
        String userInfo = new GsonBuilder().setPrettyPrinting().create().toJson(this.userRegisterRequest);
        return "An user register with following info: \n " + userInfo;
    }
}
