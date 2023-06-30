package starter.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;
import starter.models.users.UsersResponse;
import starter.util.ResponseUtil;

public class AllUsers {

    public static Question<UsersResponse> response() {
        return actor -> ResponseUtil
                .getModelFromResponse(SerenityRest.lastResponse().asString(),
                        UsersResponse.class);
    }
}
