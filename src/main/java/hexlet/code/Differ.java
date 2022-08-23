package hexlet.code;

import hexlet.code.formatter.Formatter;
import hexlet.code.formatter.Stylish;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;


public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {

        Map<String, Object> data1 = getData(filepath1);
        Map<String, Object> data2 = getData(filepath2);

        Map<String, Status> diff = Difference.findDifference(data1, data2);

        return Stylish.stylish(diff);
    }
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> data1 = getData(filepath1);
        Map<String, Object> data2 = getData(filepath2);

        Map<String, Status> diff = Difference.findDifference(data1, data2);

        return Formatter.format(diff, format);
    }
    public static Map<String, Object> getData(String filepath) throws Exception {
        int index = filepath.indexOf(".");
        int length = filepath.length();

        String extension = filepath.indexOf(".") > 0 ? filepath.substring(index + 1, length) : "";
        String content = Files.readString(Path.of(filepath));
        return Parser.parse(content, extension);
    }
}
