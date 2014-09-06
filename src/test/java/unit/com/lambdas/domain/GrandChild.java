package unit.com.lambdas.domain;

public class GrandChild implements Parent, GrandParent {

    private String message;

    @Override
    public void welcome() {
        Parent.super.welcome();
    }

    @Override
    public void message(String message) {
        this.message = message;
    }

    @Override
    public String getLastMessage() {
        return message;
    }
}
