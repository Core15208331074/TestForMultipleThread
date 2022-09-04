package demo.thread.testForConcurrentModificationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 测试并发情况下ArrayList抛出的异常
 *
 * @exception java.util.ConcurrentModificationException
 */
public class TestForConcurrentModificationException {

    public static void main(String[] args) {
//        //没有做并发控制
//        testWithNoConcurrentControl();
//        //用Vector做并发控制
//        testWithVector();
        //用CopyOnWriteArrayList做并发控制
        testWithCopyOnWriteArrayList();

    }

    /**
     * 没有做并发控制
     *
     * @throws java.util.ConcurrentModificationException
     */
    public static void testWithNoConcurrentControl() {
        List<String> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
                System.out.println(list);
            }, Thread.currentThread().getName()).start();
        }
    }


    /**
     * 用Vector做并发控制
     *
     * @throws java.util.ConcurrentModificationException
     */
    public static void testWithVector() {
        List<String> list = new Vector<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
                System.out.println(list);
            }, Thread.currentThread().getName()).start();
        }
    }


    /**
     * 用CopyOnWriteArrayList做并发控制
     * 基础于COW（一种优化策略）————多线程操作集合时，写入时复制，写入时避免覆盖
     *
     * @throws java.util.ConcurrentModificationException
     */
    public static void testWithCopyOnWriteArrayList() {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
                System.out.println(list);
            }, Thread.currentThread().getName()).start();
        }
    }

}
