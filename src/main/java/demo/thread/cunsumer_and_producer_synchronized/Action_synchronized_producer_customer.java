package demo.thread.cunsumer_and_producer_synchronized;

public class Action_synchronized_producer_customer {

    public static void main(String[] args) {
        ResourceForTestingTraditionalWay resourceForTestingTraditionalWay = new ResourceForTestingTraditionalWay();
        new Thread(() -> {
            resourceForTestingTraditionalWay.increase();
        }).start();

        new Thread(() -> {
            resourceForTestingTraditionalWay.reduce();
        }).start();


        new Thread(() -> {
            resourceForTestingTraditionalWay.increase();
        }).start();

        new Thread(() -> {
            resourceForTestingTraditionalWay.reduce();
        }).start();
    }

}
