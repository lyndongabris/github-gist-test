package api.payload.post;

public class GistFileContent {
    private String content;

    public GistFileContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
