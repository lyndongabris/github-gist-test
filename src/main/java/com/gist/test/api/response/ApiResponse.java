package com.gist.test.api.response;

import com.gist.test.api.data.responsedata.GistDataList;
import com.gist.test.api.data.responsedata.GistResponseData;
import com.gist.test.api.endpoint.ApiEndpoint;
import com.gist.test.api.response.raw.RawApiResponse;
import com.gist.test.exception.GistTestRuntimeException;
import com.gist.test.util.StringUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public interface ApiResponse<Data extends GistResponseData> {

    static <Response extends ApiResponse> Response toType(ApiResponse response, Class<Response> responseClass) {
        try {
            Constructor<Response> constructor = responseClass.getDeclaredConstructor(ApiResponse.class);
            return constructor.newInstance(response);
        } catch (NoSuchMethodException e) {
            String message = StringUtil.format("Could not find constructor for class {} which takes a single ApiResponse", responseClass.getSimpleName());
            throw new GistTestRuntimeException(message, e);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            String message = StringUtil.format("Could not instantiate an ApiReponse of type {}", responseClass.getSimpleName());
            throw new GistTestRuntimeException(message, e);
        }
    }

    ApiEndpoint getRequest();

    RawApiResponse getRawResponse();

    String getStringResponse();

    GistDataList getDataObject();

    Class<Data> getDataObjectClass();

    boolean isSuccessful();

    ApiResponse<Data> checkSuccess(boolean throwException);

    ApiResponse<Data> checkSuccess();

    int getStatusCode();

    int getSuccessCode();
}
