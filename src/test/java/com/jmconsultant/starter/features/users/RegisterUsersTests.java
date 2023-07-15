package com.jmconsultant.starter.features.users;

import com.jmconsultant.starter.conf.BaseTest;
import com.jmconsultant.starter.factories.RegisteredUser;
import com.jmconsultant.starter.facts.AnUserRegistered;
import com.jmconsultant.starter.models.register.UserRegisterRequest;
import com.jmconsultant.starter.util.StringToJson;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Narrative;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

@ExtendWith(SerenityJUnit5Extension.class)
@Narrative(text = {"As a user",
        "I want to be able to ..",
        "in order to ..."})
@DisplayName("Register users feature")
public class RegisterUsersTests extends BaseTest {

    @Test
    @DisplayName("Register an user")
    void registerAnUserFactSample(){

        UserRegisterRequest userToRegisterWithDefaultInfo =
                RegisteredUser.withDefaultInfo();

        actor.has(
                AnUserRegistered.withInfo(userToRegisterWithDefaultInfo)
        );


    }
}
