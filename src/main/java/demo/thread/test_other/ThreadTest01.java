package demo.thread.test_other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;


/**
 * Thread 测试
 */
public class ThreadTest01 {

    @Test
    public void test01() throws InterruptedException,Exception{
//        MyThread myThread = new MyThread();
//        myThread.start();
//        /**********************************************************************/
//        MyThreadRunnable myThreadRunnable = new MyThreadRunnable();
//        myThreadRunnable.run();
//        /**********************************************************************/
//        LockSupport.park();
//        MyThreadCallable myThreadCallable = new MyThreadCallable();
//        Thread.sleep(1000);
//        String call = null;
//        call = myThreadCallable.call().toString();
        /**********************************************************************/
        new Thread(() -> {
            System.out.println("111");
        }).start();
        /**********************************************************************/

        System.out.println("????");

    }


}
