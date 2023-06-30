package starter.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;
import starter.models.users.SingleUserResponse;
import starter.util.ResponseUtil;

public class SingleUser {

    public static Question<SingleUserResponse> response() {
        return actor -> ResponseUtil
                .getModelFromResponse(SerenityRest.lastResponse().asString(),
                        SingleUserResponse.class);
    }
}
