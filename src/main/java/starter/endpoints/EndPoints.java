package starter.endpoints;

public enum EndPoints {
    GET_ALL_USERS("/api/users"),
    GET_SINGLE_USER("/api/users/{user_id}")
    ;

    private final String path;

    EndPoints(String path) {
        this.path = path;
    }

    public String path() {
        return path;
    }
}
