package api.response;

import api.endpoint.ApiEndpoint;
import api.response.raw.RawApiResponse;

public interface ApiResponse {

    ApiEndpoint getRequest();

    RawApiResponse getRawResponse();

    String getStringResponse();

    boolean isSuccessful();

    ApiResponse checkSuccess(boolean throwException);

    ApiResponse checkSuccess();

    int getStatusCode();

    int getSuccessCode();
}
