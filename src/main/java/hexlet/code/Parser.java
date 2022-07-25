package hexlet.code;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.io.File;

public class Parser {
    //TODO no files only PARSE files
    public static Map<String, Object> parse(String filepath) throws IOException {
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        byte[] mapData = Files.readAllBytes(Paths.get(filepath));
        try {
            return  mapper.readValue(mapData, new TypeReference<Map<String,Object>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
