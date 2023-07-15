package com.jmconsultant.starter.questions;

import com.jmconsultant.starter.models.users.UsersResponse;
import com.jmconsultant.starter.util.ResponseUtil;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class AllUsers {

    public static Question<UsersResponse> response() {
        return actor -> ResponseUtil
                .getModelFromResponse(SerenityRest.lastResponse().asString(),
                        UsersResponse.class);
    }
}
