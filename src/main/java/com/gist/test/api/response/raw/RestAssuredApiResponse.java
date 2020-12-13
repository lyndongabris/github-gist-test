package com.gist.test.api.response.raw;


import io.restassured.response.Response;

public class RestAssuredApiResponse implements RawApiResponse {
    private final Response response;

    public RestAssuredApiResponse(Response response) {
        this.response = response;
    }

    @Override
    public int getStatusCode() {
        return response.getStatusCode();
    }

    @Override
    public String getStringResponse() {
        return response.asString();
    }

    @Override
    public String getHeaderValue(String headerKey) {
        return response.header(headerKey);
    }
}
