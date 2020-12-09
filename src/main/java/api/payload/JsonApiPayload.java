package api.payload;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exception.GistTestRuntimeException;
import io.restassured.http.ContentType;

public abstract class JsonApiPayload extends AbstractApiPayload {
    @Override
    public String getPayloadString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new GistTestRuntimeException("Failed to convert object to json", e);
        }
    }


    @Override
    public ContentType getContentType() {
        return ContentType.JSON;
    }
}
