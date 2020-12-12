package com.gist.test.api.data.responsedata.deserializer;

import com.gist.test.api.data.responsedata.GistFileInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class GistFileInfoDeserializer extends StdDeserializer<GistFileInfo> {
    public GistFileInfoDeserializer() {
        this(null);
    }

    public GistFileInfoDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public GistFileInfo deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);
        String filename = node.get("filename").asText();
        String type = node.get("type").asText();
        String language = node.get("language").asText();
        String rawUrl = node.get("raw_url").asText();
        int size = (Integer)node.get("size").numberValue();
        Boolean truncated = node.has("truncated") ? node.get("truncated").asBoolean() : null;
        String content = node.has("content") ? node.get("content").asText() : null;

        return new GistFileInfo(filename, type, language, rawUrl, size, truncated, content);
    }
}
