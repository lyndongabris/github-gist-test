package api.request;

import java.net.URI;

import api.endpoint.ApiMethod;
import api.payload.ApiPayload;
import api.response.raw.RawApiResponse;

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
