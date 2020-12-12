package api.response;

import api.data.GistDataList;
import api.data.response.GistResponseData;
import api.endpoint.ApiEndpoint;
import api.response.raw.RawApiResponse;
import exception.GistTestRuntimeException;
import util.StringUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

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

    ApiResponse checkSuccess(boolean throwException);

    ApiResponse checkSuccess();

    int getStatusCode();

    int getSuccessCode();
}
