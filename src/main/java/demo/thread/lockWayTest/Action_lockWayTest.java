package demo.thread.lockWayTest;

import java.util.concurrent.TimeUnit;

public class Action_lockWayTest {

    public static void main(String[] args) {
//        //测试对对象加锁
//        testForSalesperson1();
//        //测试对两个类型相同的对象加锁
//        testForTwoSalespersonsBasedOnSameClass();
        //测试对两个类型不同的对象的静态方法加锁，即对该类对应的Class对象加锁
        testForTwoSalespersonsBasedOnDifferentClass();
    }


    /**
     * 测试对对象加锁
     */
    public static void testForSalesperson1() {
        Salesperson1 salesperson1 = new Salesperson1();
        new Thread(() -> {
            //sendEmail()被synchronized修饰，此时salesperson1调用该方法，那么salesperson1则会被加锁
            salesperson1.sendEmail();
        }).start();

        try {
            //沉睡1s
//            Thread.sleep(1000);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            salesperson1.call();
        }).start();
    }


    /**
     * 测试对两个类型相同的对象加锁
     */
    public static void testForTwoSalespersonsBasedOnSameClass() {
        Salesperson1 salesperson1_1 = new Salesperson1();
        Salesperson1 salesperson1_2 = new Salesperson1();
        new Thread(() -> {
            salesperson1_1.sendEmail();
        }).start();

        try {
            //沉睡1s
//            Thread.sleep(1000);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            salesperson1_2.call();
        }).start();
    }


    /**
     * 测试对对该类对应的Class对象加锁
     */
    public static void testForTwoSalespersonsBasedOnDifferentClass() {
        Salesperson2 salesperson2 = new Salesperson2();
        new Thread(() -> {
            salesperson2.sendEmail();
        }).start();

        try {
            //沉睡1s
//            Thread.sleep(1000);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            salesperson2.call();
        }).start();

        new Thread(() -> {
            salesperson2.travel();
        }).start();
    }
}
