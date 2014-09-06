package unit.com.lambdas.domain;

public class ParentImpl implements Parent {

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
