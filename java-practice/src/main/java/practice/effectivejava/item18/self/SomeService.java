package practice.effectivejava.item18.self;

public class SomeService {

    public void performAsync(SomethingWithCallback callback) {
        new Thread(() -> {
            perform();
            callback.call();
        }).start();
    }

    void perform() {
        System.out.println("Service is being performed");
    }
}
