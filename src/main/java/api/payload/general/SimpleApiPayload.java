package api.payload.general;

import api.payload.AbstractApiPayload;
import io.restassured.http.ContentType;

import static com.google.common.base.Preconditions.checkNotNull;

public class SimpleApiPayload extends AbstractApiPayload {
    private String payloadString;

    public SimpleApiPayload(String payloadString) {
        checkNotNull(payloadString, "payload string cannot be null");
        this.payloadString = payloadString;
    }

    @Override
    public String getPayloadString() {
        return payloadString;
    }

    @Override
    public ContentType getContentType() {
        return ContentType.TEXT;
    }
}
