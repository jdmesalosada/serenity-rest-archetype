package conf;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.Stage;
import net.thucydides.core.util.EnvironmentVariables;
import actors.CastOfUsers;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class SettingTheStage {
    EnvironmentVariables environmentVariables;
    private static Stage currentStage;

    @Before
    public void set_the_stage() {
        currentStage = setTheStage(new CastOfUsers(environmentVariables));
    }

    public static Stage getCurrentScenarioStage(){
        return currentStage;
    }
}
