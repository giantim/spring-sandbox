package practice.effectivejava.item18.self;

public class SelfTest {

    public static void main(String[] args) {
        SomeService service = new SomeService();
        WrappedObject wrappedObject = new WrappedObject(service);
        Wrapper wrapper = new Wrapper(wrappedObject);

        wrapper.doSomething();
    }
}
