package com.gist.test.api.request;

import com.gist.test.api.endpoint.ApiEndpoint;
import com.gist.test.api.endpoint.ApiMethod;
import com.gist.test.api.response.raw.RawApiResponse;
import com.gist.test.api.response.raw.RestAssuredApiResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

import static io.restassured.RestAssured.given;

public class RestAssuredApiRequest extends AbstractApiRequest {
    private static final Logger LOG = LoggerFactory.getLogger(RestAssuredApiRequest.class);

    private final RequestSpecification request;
    private ApiMethod method;

    public RestAssuredApiRequest(ApiEndpoint endpoint) {
        super(endpoint);
        request = given();
        setBodyFromPayload();
    }

    @Override
    protected void setBodyFromPayload() {
        request.body(getPayload().getPayloadString());
    }

    @Override
    public ApiRequest baseUri(URI baseUri) {
        request.baseUri(baseUri.toString());
        return this;
    }

    @Override
    public ApiRequest httpMethod(ApiMethod requestType) {
        this.method = requestType;
        return this;
    }

    @Override
    public ApiRequest requestPath(String requestPath) {
        request.basePath(requestPath);
        return this;
    }

    @Override
    public ApiRequest accept(String contentType) {
        request.accept(ContentType.fromContentType(contentType));
        return this;
    }

    @Override
    public ApiRequest contentType(String contentType) {
        request.contentType(ContentType.fromContentType(contentType));
        return this;
    }

    @Override
    public ApiRequest header(String key, Object value) {
        request.header(key, value);
        return this;
    }

    @Override
    public ApiRequest queryParam(String key, Object value) {
        request.queryParam(key, value);
        return this;
    }

    @Override
    public ApiRequest proxy(String proxyUrl, int proxyPort) {
        request.proxy(proxyUrl, proxyPort);
        return this;
    }

    @Override
    public RawApiResponse makeRequest() {
        // Make an HTTP request of the appropriate type, and save to a response object
        if (LOG.isDebugEnabled()) {
            request.log().all();
        }

        Response response;
        switch (method) {
            case GET:
                response = request.get();
                break;
            case POST:
                response = request.post();
                break;
            case DELETE:
                response = request.delete();
                break;
            case PATCH:
                response = request.patch();
            default:
                throw new IllegalArgumentException("Unsupported method " + method);
        }

        return new RestAssuredApiResponse(response);
    }
}
