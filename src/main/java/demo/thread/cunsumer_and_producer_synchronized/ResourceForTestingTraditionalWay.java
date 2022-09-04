package demo.thread.cunsumer_and_producer_synchronized;

/***
 * 生产者
 */
public class ResourceForTestingTraditionalWay {
    private int number = 1;

    /**
     * @param
     */
    public synchronized void increase() {
        //此处用if会造成虚假唤醒
        while (number != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        /**
         *  唤醒在一个对象的监视器上等待此对象的线程
         *  任何在此对象监视器上排队等待的对象都会被随机选中唤醒
         *  唤醒是随机的（arbitrary）、任意的
         *  通过调用waite()方法使得线程等待对象的使用权
         *  被唤醒的线程不会立即执行直到当前线程放弃（relinquish）对象锁,当前线程放弃锁后，
         *  被唤醒的线程们会相互之间竞争被加锁的对象
         *  被唤醒的线程在竞争一个对象锁的拥有权时是没有可靠的特权或劣势的
         *  此方法应该只能被对象锁的当前持有者调用
         *  成为对象锁持有者的方法：
         *     1、执行对象的同步实例方法；
         *     2、执行对一个对象的同步代码块，例如：synchronized (new Object()){ body statement }
         *     3、对于Class类型的对象，通过执行该类的同步静态方法（For objects of type Class, by executing a synchronized static method of that class）
         *  一次只能有一个线程成为对象的拥有者
         */
        this.notify();
        System.out.println(Thread.currentThread().getName() + "=>" + number);
    }


    /**
     * @param
     */
    public synchronized void reduce() {
        //此处用if会造成虚假唤醒
        while (number == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        this.notify();
    }
}
