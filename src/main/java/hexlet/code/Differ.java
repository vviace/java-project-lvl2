package hexlet.code;

import hexlet.code.formatter.Json;
import hexlet.code.formatter.Plain;
import hexlet.code.formatter.Stylish;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {

        Map<String, Object> data1 = getData(filepath1);
        Map<String, Object> data2 = getData(filepath2);
        //   find difference
        Map<String, Status> diff = genDiff(data1, data2);
        //  Format data
        return Stylish.stylish(diff);
    }
    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        Map<String, Object> data1 = getData(filepath1);
        Map<String, Object> data2 = getData(filepath2);
        //   find difference
        Map<String, Status> diff = genDiff(data1, data2);
        //  Format data
        switch (format) {
            case "plain": return Plain.plain(diff);
            case "stylish": return Stylish.stylish(diff);
            case "json": return Json.json(diff);
            default: throw new Exception("unknown format: " + format);
        }
    }
    public static Map<String, Object> getData(String filepath) throws Exception {
        int index = filepath.indexOf(".");
        int length = filepath.length();
        String extention = filepath.indexOf(".") > 0 ? filepath.substring(index + 1, length) : "";
        String content = Files.readString(Path.of(filepath));
        Map<String, Object> data = Parser.parse(content, extention);

        return data;
    }

    public static Map<String, Status> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = new TreeSet<>(data1.keySet());
        Map<String, Status> result = new LinkedHashMap<>();
        keys.addAll(data2.keySet());

        for (String key : keys) {
            if (!data1.containsKey(key)) {
                result.put(key, new Status(Status.ADDED, data2.get(key), data2.get(key)));
            } else if (!data2.containsKey(key)) {
                result.put(key, new Status(Status.DELETED, data1.get(key), data1.get(key)));
            } else if (data1.get(key) != null && data2.get(key) != null && data1.get(key).equals(data2.get(key))) {
                result.put(key, new Status(Status.UNCHANGED, data2.get(key), data2.get(key)));
            } else  {
                result.put(key, new Status(Status.CHANGED, data1.get(key), data2.get(key)));
            }
        }
        return result;
    }

}
