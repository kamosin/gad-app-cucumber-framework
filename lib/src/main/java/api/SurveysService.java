package api;

import io.restassured.response.Response;

public class SurveysService {

    private final RequestManager requestManager;
    private static final String surveysEndpoint = "/api/surveys/statistics";

    public SurveysService(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    public Response getRestApiSurveyStatistics(){
        return requestManager.get(surveysEndpoint+"/1");
    }

    public Response getAutomationSurveyStatistics(){
        return requestManager.get(surveysEndpoint+"/2");
    }
}
