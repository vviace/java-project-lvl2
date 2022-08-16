package hexlet.code.formatter;

import hexlet.code.Status;
import java.util.Map;

public class Formatter {
    public static String format(Map<String, Status> diff, String format) throws Exception {
        return switch (format) {
            case "plain" -> Plain.plain(diff);
            case "stylish" -> Stylish.stylish(diff);
            case "json" -> Json.json(diff);
            default -> throw new Exception("unknown format: " + format);
        };
    }
}
