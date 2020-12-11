package api.data;

import api.data.response.GistFileInfo;
import api.data.response.deserializer.GistFileInfoDeserializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import exception.GistTestRuntimeException;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public interface GistData {
    Supplier<ObjectMapper> jackson = () -> {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(new Jdk8Module());
        return mapper;
    };

    static <Data extends GistData> List<Data> fromJson(String json, Class<Data> clazz) {
        ObjectMapper mapper = jackson.get();

        boolean isArray = json.substring(0, 1).equals("[");
        try {
            if (isArray) {
                return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
            } else {
                Data data = mapper.readValue(json, clazz);
                return Collections.singletonList(data);
            }
        } catch (IOException e) {
            throw new GistTestRuntimeException("Unable to parse Json to data object");
        }
    }

    default String toJson() {
        ObjectMapper mapper = jackson.get();

        // Write Specific Setup
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new GistTestRuntimeException("Failed to convert object to json", e);
        }
    }

}
