package demo.thread.cunsumer_and_producer_Lock_interface;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ResourceForTestingLockInterface {

    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    /**
     * 增加
     */
    public void increase() {
        lock.lock();
        //此处用if会造成虚假唤醒
        while (number == 1) {
            try {
                condition1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
                lock.unlock();
            }
        }
        number = 1;
        condition2.signal();
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        lock.unlock();
    }


    /**
     * 消减
     */
    public void reduce() {
        lock.lock();
        //此处用if会造成虚假唤醒
        while (number == 2) {
            try {
                condition2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
                lock.unlock();
            }
        }
        number = 2;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        condition3.signal();
        lock.unlock();
    }


    /**
     * 归零
     */
    public void toZero() {
        lock.lock();
        //此处用if会造成虚假唤醒
        while (number == 3) {
            try {
                condition3.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
                lock.unlock();
            }
        }
        number = 3;
        condition1.signal();
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        lock.unlock();
    }
}
