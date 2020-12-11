package api.response;

import api.endpoint.ApiEndpoint;
import api.response.raw.RawApiResponse;
import exception.GistTestRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractApiResponse implements ApiResponse {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractApiResponse.class);
    private final ApiEndpoint endpoint;
    private final RawApiResponse response;

        protected AbstractApiResponse(ApiEndpoint endpoint, RawApiResponse response) {
            this.endpoint = endpoint;
            this.response = response;
        }

        protected AbstractApiResponse(ApiResponse response) {
            this.endpoint = response.getRequest();
            this.response = response.getRawResponse();
        }

    @Override
    public ApiEndpoint getRequest() {
        LOG.trace("Obtaining the endpoint used to make the API request");
        return endpoint;
    }

    @Override
    public RawApiResponse getRawResponse() {
        LOG.trace("Obtaining the raw response from the API call");
        return response;
    }

    @Override
    public String getStringResponse() {
        LOG.trace("Obtaining the full API response in string format");
        return getRawResponse().getStringResponse();
    }

    @Override
    public int getStatusCode() {
        LOG.trace("Obtaining the status code of the API response");
        return getRawResponse().getStatusCode();
    }

    @Override
    public boolean isSuccessful() {
        LOG.debug("Confirming that the response has a status code of {}", getSuccessCode());
        return getStatusCode() == getSuccessCode();
    }

    @Override
    public ApiResponse checkSuccess(boolean throwException) {
        if (!isSuccessful() && throwException) {
            throw new GistTestRuntimeException("Returned status code did not match expected value");
        } else {
            LOG.error("Returned status code did not match expected value");
        }
        return this;
    }

    @Override
    public ApiResponse checkSuccess() {
            return checkSuccess(false);
    }
}