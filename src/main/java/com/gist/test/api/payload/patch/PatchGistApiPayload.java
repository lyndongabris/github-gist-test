package com.gist.test.api.payload.patch;

import com.gist.test.api.data.requestdata.GistWriteData;
import com.gist.test.api.payload.JsonApiPayload;

public class PatchGistApiPayload extends JsonApiPayload {
    public PatchGistApiPayload(GistWriteData data) {
        super(data);
    }
}
