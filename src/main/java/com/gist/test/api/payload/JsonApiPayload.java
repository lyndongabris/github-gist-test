package com.gist.test.api.payload;

import com.gist.test.api.data.GistData;
import io.restassured.http.ContentType;

public abstract class JsonApiPayload extends AbstractApiPayload {
    GistData data;

    protected JsonApiPayload(GistData data) {
        this.data = data;
    }

    @Override
    public String getPayloadString() {
        if (data != null) {
            return data.toJson();
        }
        return "";
    }


    @Override
    public ContentType getContentType() {
        return ContentType.JSON;
    }
}
