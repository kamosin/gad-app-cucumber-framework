package testutils.contexts;

import api.models.UserRequest;

public class UserContext {

    private UserRequest user;

    public UserRequest getUser() {
        return user;
    }

    public void setUser(UserRequest user) {
        this.user = user;
    }
}
