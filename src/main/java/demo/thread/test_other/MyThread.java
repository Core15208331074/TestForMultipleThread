package demo.thread.test_other;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("111");
        super.run();
    }
}
