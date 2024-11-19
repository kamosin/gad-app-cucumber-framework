package testutils.contexts;

import api.RequestManager;

public class ApiTestContext {

    public RequestManager requestManager;

    public ApiTestContext(RequestManager requestManager) {
        this.requestManager = requestManager;
    }
}
