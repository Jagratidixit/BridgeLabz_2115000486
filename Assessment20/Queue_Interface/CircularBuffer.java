    import java.util.*;

class CircularBuffer {
    private int[] buffer;
    private int front, rear, size, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int value) {
        rear = (rear + 1) % capacity;
        buffer[rear] = value;
        if (size < capacity) {
            size++;
        } else {
            front = (front + 1) % capacity; // Overwrite oldest element
        }
    }

    public List<Integer> getBuffer() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(buffer[(front + i) % capacity]);
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.enqueue(1);
        cb.enqueue(2);
        cb.enqueue(3);
        System.out.println(cb.getBuffer()); // Output: [1, 2, 3]

        cb.enqueue(4);
        System.out.println(cb.getBuffer()); // Output: [2, 3, 4]
    }
}
