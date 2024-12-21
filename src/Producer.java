public class Producer implements Runnable {

    private final MessageQueue messageQueue;

    public Producer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        int counter = 1;
        for (int i = 1; i <= 10; i++) {
            try {
                String message = "Message: " + counter++;
                messageQueue.produce(message);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException is thrown from producer for message: " + messageQueue);
            }
        }
    }
}
