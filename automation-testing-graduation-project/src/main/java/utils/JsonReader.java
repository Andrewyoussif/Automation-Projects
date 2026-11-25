package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JsonReader {
    private static final JsonNode data;

    static {
        try (InputStream in = JsonReader.class.getClassLoader().getResourceAsStream("testdata.json")) {
            data = new ObjectMapper().readTree(in);
        } catch (IOException e) {
            throw new RuntimeException("Could not load testdata.json", e);
        }
    }

    public static JsonNode get() {
        return data;
    }
}
