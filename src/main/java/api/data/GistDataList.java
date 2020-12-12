package api.data;

import java.util.List;

public class GistDataList<Data extends GistData> implements GistData {
    List<Data> gists;

    public GistDataList(List<Data> gists) {
        this.gists = gists;
    }

    public List<Data> getGists() {
        return gists;
    }

    public void setGists(List<Data> gists) {
        this.gists = gists;
    }
}
