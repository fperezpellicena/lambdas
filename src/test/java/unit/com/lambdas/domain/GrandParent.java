package unit.com.lambdas.domain;

public interface GrandParent {

    void message(String message);

    public default void welcome() {
        message("Grand parent: Hi!");
    }

    public String getLastMessage();
}
