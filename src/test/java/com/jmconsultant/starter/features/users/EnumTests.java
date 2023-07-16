package com.jmconsultant.starter.features.users;

import com.jmconsultant.starter.conf.BaseTest;
import com.jmconsultant.starter.enums.UserStatus;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EnumTests extends BaseTest {

    @Test
    @DisplayName("get enum by description")
    void getEnumByDescription() {

        UserStatus userStatus = UserStatus.findByDescription("active user");

        actor.attemptsTo(
                Ensure.that(userStatus).isEqualTo(UserStatus.ACTIVE)
        );

    }
}