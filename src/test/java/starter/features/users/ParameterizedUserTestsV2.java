package starter.features.users;


import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import starter.conf.BaseTest;

@RunWith(SerenityParameterizedRunner.class)
public class ParameterizedUserTestsV2 extends BaseTest {

    private String name;
    private String lastName;

    @ParameterizedTest
    @ValueSource(strings = { "Hello", "JUnit" ,"5"})
    @Execution(ExecutionMode.CONCURRENT)
    @TestFactory
    public void should_UserSignUpSuccessfully_When_HeSendsCompleteInformation(
            String name
    ) {
        System.out.println(name);
        System.out.println("thread id: " + Thread.currentThread().getId());
    }
}