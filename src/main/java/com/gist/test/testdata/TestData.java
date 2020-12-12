package com.gist.test.testdata;

import com.gist.test.api.data.requestdata.GistWriteData;
import com.gist.test.api.data.responsedata.GistResponseData;
import com.gist.test.api.endpoint.get.GetSpecificGistApiEndpoint;
import com.gist.test.api.endpoint.post.CreateGistApiEndpoint;
import com.gist.test.api.response.get.GetGistApiResponse;
import com.gist.test.api.response.post.PostGistApiResponse;
import com.gist.test.util.PropertiesUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestData {
    private List<String> createdGistIds;
    private static TestData instance;
    private GistWriteData lastGistWrite;

    public static TestData get() {
        if (instance == null) {
            instance = new TestData();
        }
        return instance;
    }

    private List<String> getGistIds() {
        if (createdGistIds == null) {
            createdGistIds = new ArrayList<>();
        }
        return createdGistIds;
    }

    public void clearCreatedGistIds() {
        createdGistIds.clear();
    }

    public void createGist(GistWriteData data) {
        this.lastGistWrite = data;
        String token = PropertiesUtil.getSystem("gist.token");
        PostGistApiResponse response = CreateGistApiEndpoint.create(token, data);
        getGistIds().add(response.getDataObject().getGists().get(0).getId());
    }

    public GistResponseData getGist(String gistId) {
        GetGistApiResponse response = GetSpecificGistApiEndpoint.get(gistId);
        return response.getDataObject().getGists().get(0);
    }
}
