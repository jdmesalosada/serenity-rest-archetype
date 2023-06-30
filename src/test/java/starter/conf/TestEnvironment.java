package starter.conf;

import net.thucydides.core.util.EnvironmentVariables;

public class TestEnvironment {
    // Automatically injected by Serenity
    private EnvironmentVariables environmentVariables;

    public TestEnvironment(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    public String getRestAPIBaseUrl() {
        return "https://reqres.in";
    }
}
