package unit.com.lambdas.domain;

public interface Parent {

    public static String getParentName() {
        return "Parent name";
    }

    void message(String message);

    public default void welcome() {
        message("Parent: Hi!");
    }

    public String getLastMessage();
}
