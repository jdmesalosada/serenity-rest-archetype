package conf;

import net.thucydides.core.util.EnvironmentVariables;

public class TestEnvironment {
    // Automatically injected by Serenity
    private EnvironmentVariables environmentVariables;

    public TestEnvironment(EnvironmentVariables environmentVariables) {
        /*if (System.getProperty("env") == null) {
            throw new IllegalArgumentException("You have to define the env variable with any of these values: local, dev or uat");
        }*/
        this.environmentVariables = environmentVariables;
    }

    public String getRestAPIBaseUrl() {
        return "https://reqres.in";
    }
}
