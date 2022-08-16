package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Difference {
    public static Map<String, Status> findDifference(Map<String, Object> data1, Map<String, Object> data2) {
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
