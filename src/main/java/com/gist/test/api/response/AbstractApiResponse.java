package com.gist.test.api.response;

import com.gist.test.api.data.GistData;
import com.gist.test.api.data.responsedata.GistDataList;
import com.gist.test.api.data.responsedata.GistResponseData;
import com.gist.test.api.endpoint.ApiEndpoint;
import com.gist.test.api.response.raw.RawApiResponse;
import com.gist.test.exception.GistTestRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractApiResponse<Data extends GistResponseData> implements ApiResponse<Data> {
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
    public GistDataList getDataObject() {
        checkSuccess();
        return new GistDataList(GistData.fromJson(getStringResponse(), GistResponseData.class));
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
    public ApiResponse<Data> checkSuccess(boolean throwException) {
        if (!isSuccessful() && throwException) {
            throw new GistTestRuntimeException("Returned status code '{}' did not match expected value '{}'", getStatusCode(), getSuccessCode());
        } else if (!isSuccessful()) {
            LOG.error("Returned status code did not match expected value");
        }
        return this;
    }

    @Override
    public ApiResponse<Data> checkSuccess() {
            return checkSuccess(true);
    }
}
