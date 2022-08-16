package hexlet.code;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.util.Map;


public class Parser {
    public static Map<String, Object> parse(String content, String extension) throws Exception {
        switch (extension) {
            case "yml" : return parseYml(content);
            case "json" : return parseJson(content);
            default: throw new Exception("unknown extension" + extension);
        }

    }
    public static Map<String, Object> parseYml(String content) throws IOException {
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return  mapper.readValue(content, new TypeReference<Map<String, Object>>() { });
    }

    public static Map<String, Object> parseJson(String content) throws IOException {
        final ObjectMapper mapper = new ObjectMapper(new JsonFactory());
        return  mapper.readValue(content, new TypeReference<Map<String, Object>>() { });
    }
}
