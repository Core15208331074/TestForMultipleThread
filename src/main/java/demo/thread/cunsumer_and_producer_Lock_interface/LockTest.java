package demo.thread.cunsumer_and_producer_Lock_interface;


public class LockTest {

    public static void main(String[] args) {
        ResourceForTestingLockInterface resourceForTestingLockInterface = new ResourceForTestingLockInterface();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resourceForTestingLockInterface.increase();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resourceForTestingLockInterface.reduce();
            }
        }, "B").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resourceForTestingLockInterface.toZero();
            }
        }, "C").start();
    }
}
