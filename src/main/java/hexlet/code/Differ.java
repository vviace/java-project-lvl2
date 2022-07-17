package hexlet.code;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Differ {
//    public static void getData(String content) throws Exception {
//        return parse(content);
//    }
    
    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        // TODO: read files,
        Map<String, Object> data1 = getData(filepath1);
        Map<String, Object> data2 = getData(filepath2);
        //  TODO: find diference;
        System.out.println(genDiff(data1,data2));
        return "";
        // TODO: Format data ;

    }
    public static Map<String, Object>  getData (String filepath) throws IOException {
       String content = Files.readString(Path.of(filepath));
       ObjectMapper mapper = new ObjectMapper();
       Map<String, Object> result = mapper.readValue(content, Map.class);

//       for (Map.Entry<String, Object> entry : result.entrySet()) {
//           System.out.println(entry.getKey() + ": " + entry.getValue().toString());
//       }
       return result;
    }

    public static String genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new LinkedHashMap<>();
        Set<String> keys = new TreeSet<>(data1.keySet());
        String differ = "{ \n";
        keys.addAll(data2.keySet());
        for (String key : keys) {
            if (!data1.containsKey(key)) {
                //result.put(key,"added");
                differ = differ + " + " + key + ": " + data2.get(key).toString() + "\n";
            } else if (!data2.containsKey(key)) {
                //result.put(key,"deleted");
                differ = differ + " - " + key + ": " + data1.get(key).toString() + "\n";
            } else if (data1.get(key).equals(data2.get(key))) {
                //result.put(key,"unchanged");
                differ = differ + "   " + key + ": " + data2.get(key).toString() + "\n";
            } else {
                differ = differ + " - " + key + ": " + data1.get(key).toString() + "\n";
                differ = differ + " + " + key + ": " + data2.get(key).toString() + "\n";
                //result.put(key,"changed");
            }
        }
        //System.out.println(differ + "}");
        return differ + "}";

    }
}
