package api.payload;

import io.restassured.http.ContentType;

public interface ApiPayload {
    String getPayloadString();
    ContentType getContentType();
}
