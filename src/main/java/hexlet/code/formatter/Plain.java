package hexlet.code.formatter;

import hexlet.code.Status;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String plain(Map<String, Status> diff) throws Exception {
        String differ = "";

        for (Map.Entry<String, Status> item : diff.entrySet()) {
            String status = item.getValue().getStatusName();
            String prev = objToString(item.getValue().getPreviousValue());
            String current = objToString(item.getValue().getCurrentValue());
            switch (status) {
                case Status.ADDED: differ = differ + "Property '" + item.getKey() + "' was added with value: "
                        + current + "\n";
                    break;
                case Status.DELETED: differ = differ + "Property '" + item.getKey() + "' was removed" + "\n";
                    break;
                case Status.CHANGED: differ = differ + "Property '" + item.getKey() + "' was updated. From "
                        + prev + " to "
                        + current + "\n";
                    break;
                case Status.UNCHANGED:
                    break;
                default: throw new Exception("unknown status " + status);
            }
        }
        return differ;
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
