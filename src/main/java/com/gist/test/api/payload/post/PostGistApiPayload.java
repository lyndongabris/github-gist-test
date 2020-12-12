package com.gist.test.api.payload.post;

import com.gist.test.api.data.requestdata.GistWriteData;
import com.gist.test.api.payload.JsonApiPayload;

public class PostGistApiPayload extends JsonApiPayload {
    public PostGistApiPayload(GistWriteData data) {
        super(data);
    }
}