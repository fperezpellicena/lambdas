package unit.com.lambdas;

import org.junit.Test;
import unit.com.lambdas.domain.*;

import static org.junit.Assert.assertEquals;

public class FunctionalInterfacesTest {

    @Test
    public void parentDefaultMethodTest() {
        Parent parent = new ParentImpl();
        parent.welcome();

        assertEquals("Parent: Hi!", parent.getLastMessage());
    }

    @Test
    public void childDefaultMethodTest() {
        Child child = new ChildImpl();
        child.welcome();

        assertEquals("Child: Hi!", child.getLastMessage());
    }

    @Test
    public void overrideParentDefaultMethodTest() {
        Parent parent = new OverridingParent();
        parent.welcome();

        assertEquals("Class parent: Hi!", parent.getLastMessage());
    }

    @Test
    public void multipleInheritance() {
        GrandChild grandChild = new GrandChild();
        grandChild.welcome();

        assertEquals("Parent: Hi!", grandChild.getLastMessage());
    }

    @Test
    public void staticInterfaceMethods() {
        assertEquals("Parent name", Parent.getParentName());
    }

}
