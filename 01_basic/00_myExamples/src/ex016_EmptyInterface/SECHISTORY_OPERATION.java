package ex016_EmptyInterface;

public enum SECHISTORY_OPERATION {

    INSERT("insert"),
    UPDATE("update"),
    DELETE("delete");

    private final String operation;

    SECHISTORY_OPERATION(String op) {
        this.operation = op;
    }

    @Override
    public String toString() {
        return operation;
    }

}
