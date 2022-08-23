package hexlet.code.formatter;

import hexlet.code.Status;

import java.util.Map;

public class Stylish {
    public static String stylish(Map<String, Status> diff) throws Exception {
        String differ = "{\n";

        for (Map.Entry<String, Status> item : diff.entrySet()) {
            String status = item.getValue().getStatusName();
            switch (status) {
                case Status.ADDED: differ = differ + "  + " + item.getKey() + ": "
                        + item.getValue().getCurrentValue() + "\n";
                    break;
                case Status.DELETED: differ = differ + "  - " + item.getKey() + ": "
                        + item.getValue().getPreviousValue() + "\n";
                    break;
                case Status.CHANGED: differ = differ + "  - " + item.getKey() + ": "
                        + item.getValue().getPreviousValue() + "\n"
                                                + "  + " + item.getKey() + ": "
                        + item.getValue().getCurrentValue() + "\n";
                    break;
                case Status.UNCHANGED: differ = differ + "    "  + item.getKey() + ": "
                        + item.getValue().getCurrentValue() + "\n";
                    break;

                default: throw new Exception("unknown status " + status);
            }
        }

        return differ + "}";
    }
}
