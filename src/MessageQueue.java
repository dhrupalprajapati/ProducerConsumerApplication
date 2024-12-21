import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {
    private final Queue<String> queue = new LinkedList<>();
    private final int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(String message) throws InterruptedException {
        while (queue.size() == capacity) {
            System.out.println("Message queue if full. Producer is waiting..");
            wait();
        }
        queue.add(message);
        System.out.println("Produced: " + message);
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Message queue is empty. Consumer is waiting..");
            wait();
        }
        String message = queue.poll();
        System.out.println("Consumed: " + message);
        notifyAll();
    }

}
