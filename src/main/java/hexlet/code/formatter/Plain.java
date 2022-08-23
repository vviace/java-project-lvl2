package hexlet.code.formatter;

import hexlet.code.Status;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String plain(Map<String, Status> diff) throws Exception {

        StringBuilder differ = new StringBuilder();
        int size = diff.size();
        for (Map.Entry<String, Status> item : diff.entrySet()) {
            String status = item.getValue().getStatusName();
            String prev = objToString(item.getValue().getPreviousValue());
            String current = objToString(item.getValue().getCurrentValue());
            String key = item.getKey();
            size = size - 1;

            switch (status) {
                case Status.ADDED: differ.append("Property '" + key + "' was added with value: " + current);
                    if (size != 0) {
                        differ.append("\n");
                    }
                    break;
                case Status.DELETED: differ.append("Property '" + key + "' was removed");
                    if (size != 0) {
                        differ.append("\n");
                    }
                    break;
                case Status.CHANGED: differ.append("Property '" + key + "' was updated. From "
                        + prev + " to " + current);
                    if (size != 0) {
                        differ.append("\n");
                    }
                    break;
                case Status.UNCHANGED:
                    break;
                default: throw new Exception("unknown status " + status);
            }

        }
        return differ.toString();
    }

    public static String objToString(Object object) {
        if (object == null) {
            return "null";
        } else if (object instanceof List || object instanceof Map) {
            return "[complex value]";
        } else if (object instanceof String) {
            return "'" + object + "'";
        } else {
            return object.toString();
        }
    }
}
