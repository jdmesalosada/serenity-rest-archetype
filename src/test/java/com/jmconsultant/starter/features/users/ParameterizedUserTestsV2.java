package com.jmconsultant.starter.features.users;


import com.jmconsultant.starter.conf.BaseTest;
import com.jmconsultant.starter.tasks.GetSingleUser;
import com.jmconsultant.starter.util.StringToJson;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

@ExtendWith(SerenityJUnit5Extension.class)
public class ParameterizedUserTestsV2 extends BaseTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4})
    //@Execution(ExecutionMode.CONCURRENT)
    public void should_get_user_by_id(
            int userId
    ) {
        actor.attemptsTo(
                GetSingleUser.byId(userId)
        );

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/users.csv", numLinesToSkip = 1)
    public void should_get_user_by_id_from_csv_file(
            int userId, String name, String lastName) {
        System.out.println("name is: " + name);
        System.out.println("lastname is: " + lastName);
        actor.attemptsTo(
                GetSingleUser.byId(userId)
        );
    }
}