package api.endpoint;

import api.payload.ApiPayload;
import api.request.ApiRequest;
import api.response.ApiResponse;

import java.net.URI;
import java.util.Map;
import java.util.Set;

public interface ApiEndpoint<R extends ApiResponse> {
    ApiMethod getMethod();
    Set<Map.Entry<String, Object>> getQueryParams();
    void addQueryParam(String key, String value);
    void addQueryParam(String key, boolean value);
    void addQueryParam(String key, int value);
    Set<Map.Entry<String, Object>> getHeaders();
    void addHeader(String key, String value);
    void addHeader(String key, boolean value);
    void addHeader(String key, int value);
    void setPayload(ApiPayload payload);
    URI getEndpointUrl();
    ApiPayload getPayload();
    ApiRequest getBaseApiRequest();
    R request();
    Class<R> getResponseClass();
}
