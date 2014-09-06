package unit.com.lambdas.domain;

public class OverridingParent extends ParentImpl {

    @Override
    public void welcome() {
        message("Class parent: Hi!");
    }
}
