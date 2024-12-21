public class ProducerConsumerTest {

    public static void main(String[] args) {
        testSuccessScenario();
        testFailureScenario();
    }

    static void testSuccessScenario() {
        System.out.println("Running Success Scenario Test...");

        MessageQueue queue = new MessageQueue(3);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread producerThread = new Thread(producer, "Producer");
        Thread consumerThread = new Thread(consumer, "Consumer");

        producerThread.start();
        consumerThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        producerThread.interrupt();
        consumerThread.interrupt();

        System.out.println("Success Scenario Test Completed...");
    }

    static void testFailureScenario() {
        System.out.println("\nRunning Failure Scenario Test...");

        MessageQueue queue = new MessageQueue(2);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread producerThread = new Thread(producer, "Producer");
        Thread consumerThread = new Thread(consumer, "Consumer");

        producerThread.start();
        consumerThread.start();

        producerThread.interrupt();
        consumerThread.interrupt();

        try {
            producerThread.join();
            producerThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Failure Scenario Test Completed.");
    }
}