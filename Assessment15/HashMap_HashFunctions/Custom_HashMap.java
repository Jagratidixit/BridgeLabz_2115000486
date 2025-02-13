   class CustomHashMap {
    private static class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 1000;
    private Node[] map;

    public CustomHashMap() {
        map = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = map[index];

        if (head == null) {
            map[index] = new Node(key, value);
        } else {
            Node curr = head;
            while (curr != null) {
                if (curr.key == key) {
                    curr.value = value;
                    return;
                }
                if (curr.next == null) {
                    curr.next = new Node(key, value);
                    return;
                }
                curr = curr.next;
            }
        }
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = map[index];

        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = map[index];

        if (curr == null) return;

        if (curr.key == key) {
            map[index] = curr.next;
            return;
        }

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        CustomHashMap hashMap = new CustomHashMap();
        hashMap.put(1, 10);
        hashMap.put(2, 20);
        System.out.println(hashMap.get(1));
        hashMap.remove(1);
        System.out.println(hashMap.get(1));
    }
}
