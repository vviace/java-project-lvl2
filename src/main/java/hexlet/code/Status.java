package hexlet.code;

public final class Status {
    public static final String ADDED = "added";
    public static final String CHANGED = "changed";
    public static final String UNCHANGED = "unchanged";
    public static final String DELETED = "deleted";
    private final String statusName;
    private final Object previousValue;
    private final Object currentValue;

    public Status(String status, Object previous, Object current) {
        this.statusName = status;
        this.previousValue = previous;
        this.currentValue = current;
    }

    public String getStatusName() {
        return statusName;
    }

    public Object getPreviousValue() {
        return previousValue;
    }

    public Object getCurrentValue() {
        return currentValue;
    }
}
