import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {

    String name();
}

class TestClass {

    @Author(name = "Jane Johnson")
    public void myMethod() {
        // some code
    }
}
