package com.jmconsultant.starter.questions;

import com.jmconsultant.starter.util.ResponseUtil;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;
import com.jmconsultant.starter.models.users.SingleUserResponse;

public class SingleUser {

    public static Question<SingleUserResponse> response() {
        return actor -> ResponseUtil
                .getModelFromResponse(SerenityRest.lastResponse().asString(),
                        SingleUserResponse.class);
    }
}
