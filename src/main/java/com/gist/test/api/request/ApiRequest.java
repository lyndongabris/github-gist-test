package com.gist.test.api.request;

import com.gist.test.api.endpoint.ApiMethod;
import com.gist.test.api.payload.ApiPayload;
import com.gist.test.api.response.raw.RawApiResponse;

import java.net.URI;

public interface ApiRequest {
    ApiRequest baseUri(URI baseUri);

    ApiRequest httpMethod(ApiMethod requestType);

    ApiRequest requestPath(String requestPath);

    ApiRequest accept(String contentType);

    ApiRequest contentType(String contentType);

    ApiRequest header(String key, Object value);

    ApiRequest queryParam(String key, Object value);

    ApiRequest proxy(String proxyUrl, int proxyPort);

    ApiPayload getPayload();

    RawApiResponse makeRequest();
}
