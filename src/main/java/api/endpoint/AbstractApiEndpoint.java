package api.endpoint;

import api.data.response.GistResponseData;
import api.payload.ApiPayload;
import api.payload.general.EmptyApiPayload;
import api.request.ApiRequest;
import api.request.RestAssuredApiRequest;
import api.response.ApiResponse;
import api.response.SimpleApiResponse;
import api.response.raw.RawApiResponse;
import io.restassured.http.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class AbstractApiEndpoint<Response extends ApiResponse> implements ApiEndpoint<Response> {
    private final static Logger LOG = LoggerFactory.getLogger(AbstractApiEndpoint.class);
    private ApiPayload payload;
    private ContentType responseContentType;
    private final URI baseUri = URI.create("https://api.github.com");

    private final Map<String, Object> queryParams;
    private final Map<String, Object> headers;

    protected AbstractApiEndpoint() {
        payload = new EmptyApiPayload();
        responseContentType = ContentType.JSON;
        queryParams = new HashMap<>();
        headers = new HashMap<>();
    }

    @Override
    public Response request() {
        ApiRequest request = getBaseApiRequest();
        ContentType requestContentType = payload.getContentType();
        LOG.trace("Api response content type is set to {}", responseContentType);
        LOG.trace("Api request content type is set to {}", requestContentType);
        request.baseUri(baseUri)
                .requestPath(getEndpointUrl().getPath())
                .accept(responseContentType.toString())
                .contentType(requestContentType.toString())
                .httpMethod(getMethod());

        addQueryStrings(request);
        addHeaders(request);

        RawApiResponse response = request.makeRequest();

        LOG.debug("Api request {} {}/{} had response {}", getMethod(), baseUri, getEndpointUrl().getPath(), response.getStatusCode());

        if (LOG.isTraceEnabled()) {
            LOG.trace("Response text:\n{}", response.getStringResponse());
        }

        return ApiResponse.toType(new SimpleApiResponse(this, response), getResponseClass());
    }

    private ApiRequest addQueryStrings(ApiRequest request) {
        if (!getQueryParams().isEmpty()) {
            getQueryParams().forEach(header -> {
                LOG.trace("Adding query string key: {} with value: {}", header.getKey(), header.getValue());
                request.queryParam(header.getKey(), header.getValue());
            });
        }

        return request;
    }

    private ApiRequest addHeaders(ApiRequest request) {
        if (!getHeaders().isEmpty()) {
            getHeaders().forEach(header -> {
                LOG.trace("Adding header key: {} with value: {}", header.getKey(), header.getValue());
                request.header(header.getKey(), header.getValue());
            });
        }

        return request;
    }

    @Override
    public ApiPayload getPayload() {
        return payload;
    }

    @Override
    public void setPayload(ApiPayload payload) {
        this.payload = payload;
    }

    @Override
    public Set<Map.Entry<String, Object>> getQueryParams() {
        return queryParams.entrySet();
    }

    @Override
    public void addQueryParam(String key, String value) {
        queryParams.put(key, value);
    }

    @Override
    public void addQueryParam(String key, boolean value) {
        queryParams.put(key, value);
    }

    @Override
    public void addQueryParam(String key, int value) {
        queryParams.put(key, value);
    }

    @Override
    public Set<Map.Entry<String, Object>> getHeaders() {
        return headers.entrySet();
    }

    @Override
    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    @Override
    public void addHeader(String key, boolean value) {
        headers.put(key, value);
    }

    @Override
    public void addHeader(String key, int value) {
        headers.put(key, value);
    }

    protected void setResponseContentType(ContentType responseContentType) {
        this.responseContentType = responseContentType;
    }

    @Override
    public ApiRequest getBaseApiRequest() {
        return new RestAssuredApiRequest(this);
    }
}
