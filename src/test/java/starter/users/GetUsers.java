package starter.users;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Narrative;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import starter.conf.BaseTest;
import starter.models.users.SingleUserResponse;
import starter.models.users.UsersResponse;
import starter.questions.AllUsers;
import starter.questions.SingleUser;
import starter.tasks.GetAllUsers;
import starter.tasks.GetSingleUser;

@ExtendWith(SerenityJUnit5Extension.class)
@Narrative(text = {"As a user",
        "I want to be able to ..",
        "in order to ..."})
public class GetUsers extends BaseTest {

    @Test
    @DisplayName("Get all the users registered")
    @Tag("users")
    void getAllUsers() {
        actor.attemptsTo(
                GetAllUsers.registered()
        );

        UsersResponse allUsers = AllUsers.response().answeredBy(actor);

        /*actor.should(
                seeThat(act -> allUsers.getPage(),
                        equalTo(1)),
                seeThat(act -> allUsers.getPer_page(),
                        equalTo(6)),
                seeThat(act -> allUsers.getTotal_pages(),
                        equalTo(2))
        );*/

        actor.attemptsTo(
                Ensure.that(allUsers.getPage()).isEqualTo(1),
                Ensure.that(allUsers.getPer_page()).isEqualTo(6),
                Ensure.that(allUsers.getTotal_pages()).isEqualTo(2));
    }

    @Test
    @DisplayName("Get a single user")
    @Tag("users")
    void getASingleUser() {
        int userId = 2;

        actor.attemptsTo(
                GetSingleUser.byId(userId)
        );

        SingleUserResponse singleUser = SingleUser.response().answeredBy(actor);

        actor.attemptsTo(
                Ensure.that(singleUser.getData().getEmail()).isEqualTo("janet.weaver@reqres.in"),
                Ensure.that(singleUser.getData().getId()).isEqualTo(userId),
                Ensure.that(singleUser.getData().getFirst_name()).isEqualTo("Janet")
        );
    }
}


