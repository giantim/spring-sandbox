package practice.effectivejava.item18.self;

public class Wrapper implements SomethingWithCallback {

    private final WrappedObject wrappedObject;

    public Wrapper(WrappedObject wrappedObject) {
        this.wrappedObject = wrappedObject;
    }

    @Override
    public void doSomething() {
        wrappedObject.doSomething();
    }

    @Override
    public void call() {
        System.out.println("Wrapper Callback!");
    }

    void doSomethingElse() {
        System.out.println("We can do everything the wrapper object can, and more!");
    }
}
