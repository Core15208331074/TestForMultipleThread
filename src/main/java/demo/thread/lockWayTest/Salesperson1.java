package demo.thread.lockWayTest;


import java.util.concurrent.TimeUnit;

/**
 * 对对象加锁
 */
public class Salesperson1 {

    /**
     * 锁的是方法的调用者
     */
    public synchronized void sendEmail() {
        try {
            //沉睡1s
//            Thread.sleep(1000);
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendEmail => Core961253412@github.com");
    }

    /**
     * 锁的是方法的调用者
     */
    public synchronized void call() {
        System.out.println("call => 961253412");
    }

}
