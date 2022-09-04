package demo.thread.lockWayTest;

import java.util.concurrent.TimeUnit;

public class Salesperson2 {

    /**
     * Class对象全局唯一,对该类的静态方法加synchronized，即对该类对应的Class对象加锁，
     * 即在加载该类的Class对象时就对Class对象加了锁，所以该类所有被synchronized修饰的静态方法的调用都需要参与锁的竞争
     */
    public static synchronized void sendEmail() {
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
     * Class对象全局唯一,对该类的静态方法加synchronized，即对该类对应的Class对象加锁，
     * 即在加载该类的Class对象时就对Class对象加了锁，所以该类所有被synchronized修饰的静态方法的调用都需要参与锁的竞争
     */
    public static synchronized void call() {
        System.out.println("call => 961253412");
    }

    /**
     * 仅仅对对象加锁
     */
    public synchronized void travel() {
        System.out.println("travel => Hamburg Germany");
    }
}
