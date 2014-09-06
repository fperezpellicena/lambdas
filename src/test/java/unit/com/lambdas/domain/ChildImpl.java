package unit.com.lambdas.domain;

public class ChildImpl implements Child {

    private String message;

    @Override
    public void message(String message) {
        this.message = message;
    }

    @Override
    public String getLastMessage() {
        return message;
    }
}
