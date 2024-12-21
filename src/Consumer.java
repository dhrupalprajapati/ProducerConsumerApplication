public class Consumer implements Runnable {
    private final MessageQueue messageQueue;

    public Consumer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                messageQueue.consume();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException is thrown from consumer with message: " + e.getMessage());
            }
        }
    }
}
