package com.gist.test.api.data.responsedata;

import com.gist.test.api.data.GistData;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GistDataList that = (GistDataList) o;
        return Objects.equals(gists, that.gists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gists);
    }
}
