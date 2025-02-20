import java.util.*;

public class ReverseQueue {
    public static Queue<Integer> reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        
        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);
        System.out.println("Reversed Queue: " + reverse(queue));
    }
}
