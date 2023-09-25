package ex014_Enum;

public enum ListStatus {
    DELIST,
    LISTED,
    RESUMED,
    SUSPENDED,
    NEW,
    NULL;

    public static ListStatus parseEdi(String s) {
        switch (s) {
            case "L": return LISTED;
            case "D": return DELIST;
            case "R": return RESUMED;
            case "S": return SUSPENDED;
            case "N": return NEW;
            case "U": return NULL;
            default: throw new IllegalArgumentException(s);
        }
    }

    public static String toString(ListStatus status) {
        switch (status) {
            case LISTED: return "L";
            case DELIST: return "D";
            case RESUMED: return "R";
            case SUSPENDED: return "S";
            case NEW: return "N";
            default: return "U";
        }
    }
}
