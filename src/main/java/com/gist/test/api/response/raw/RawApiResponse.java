package com.gist.test.api.response.raw;

public interface RawApiResponse {
    int getStatusCode();
    String getStringResponse();
    String getHeaderValue(String headerKey);
}
