package com.gist.test.api.endpoint.patch;

import com.gist.test.api.data.requestdata.GistWriteData;
import com.gist.test.api.payload.patch.PatchGistApiPayload;
import com.gist.test.api.response.patch.PatchGistApiResponse;
import com.gist.test.util.StringUtil;

import java.net.URI;

public class PatchGistApiEndpoint extends AbstractPatchGistApiEndpoint {
    private URI endpointUrl;
    private String gistId;

    public static PatchGistApiResponse update(String token, String gistId, GistWriteData data) {
        PatchGistApiEndpoint endpoint = new PatchGistApiEndpoint(token, gistId, data);
        return endpoint.request();
    }

    private PatchGistApiEndpoint(String token, String gistId, GistWriteData data) {
        this.setPayload(new PatchGistApiPayload(data));
        addAuthentication(this, token);
        this.gistId = gistId;
    }

    @Override
    public URI getEndpointUrl() {
        if (endpointUrl == null) {
            String stringEndpointUrl = StringUtil.format("/gists/{}", gistId);
            endpointUrl = URI.create(stringEndpointUrl);
        }
        return endpointUrl;
    }
}
