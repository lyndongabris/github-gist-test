package api.data;

import api.data.response.GistResponseData;

import java.util.List;

public class GistDataList implements GistData {
    List<GistResponseData> gists;

    public GistDataList(List<GistResponseData> gists) {
        this.gists = gists;
    }

    public List<GistResponseData> getGists() {
        return gists;
    }

    public void setGists(List<GistResponseData> gists) {
        this.gists = gists;
    }
}
