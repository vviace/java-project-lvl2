package hexlet.code.formatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Status;

import java.io.IOException;
import java.util.Map;

public class Json {
    public static String json(Map<String, Status> diff) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(diff);
    }
}
