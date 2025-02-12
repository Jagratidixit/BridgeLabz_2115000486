class ItemNode {
    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class ItemList {
    private ItemNode head;

    void addItemAtBegin(int itemId, String itemName, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemId, itemName, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    void addItemAtEnd(int itemId, String itemName, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemId, itemName, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    void addItemAtPos(int itemId, String itemName, int quantity, double price, int position) {
        ItemNode newNode = new ItemNode(itemId, itemName, quantity, price);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        ItemNode temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) temp = temp.next;
        if (temp == null) return;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void removeItem(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != itemId) temp = temp.next;
        if (temp.next == null) return;
        temp.next = temp.next.next;
    }

    ItemNode searchItem(int itemId) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) return temp;
            temp = temp.next;
        }
        return null;
    }

    ItemNode searchItem(String itemName) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) return temp;
            temp = temp.next;
        }
        return null;
    }

    void updateQuantity(int itemId, int newQuantity) {
        ItemNode temp = searchItem(itemId);
        if (temp != null) temp.quantity = newQuantity;
    }

    void displayInventory() {
        double totalValue = 0;
        ItemNode temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.itemId + ", Name: " + temp.itemName + ", Qty: " + temp.quantity + ", Price: " + temp.price);
            totalValue += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Value of Inventory: " + totalValue);
    }

    void sortInventoryByName() {
        head = mergeSort(head, true);
    }

    void sortInventoryByPrice() {
        head = mergeSort(head, false);
    }

    private ItemNode mergeSort(ItemNode head, boolean byName) {
        if (head == null || head.next == null) return head;
        ItemNode mid = getMiddle(head);
        ItemNode nextToMid = mid.next;
        mid.next = null;
        ItemNode left = mergeSort(head, byName);
        ItemNode right = mergeSort(nextToMid, byName);
        return merge(left, right, byName);
    }

    private ItemNode getMiddle(ItemNode head) {
        if (head == null) return head;
        ItemNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ItemNode merge(ItemNode left, ItemNode right, boolean byName) {
        if (left == null) return right;
        if (right == null) return left;
        if ((byName && left.itemName.compareToIgnoreCase(right.itemName) < 0) || 
            (!byName && left.price < right.price)) {
            left.next = merge(left.next, right, byName);
            return left;
        } else {
            right.next = merge(left, right.next, byName);
            return right;
        }
    }

    public static void main(String[] args) {
        ItemList list = new ItemList();
        list.addItemAtBegin(1000, "Dyson", 3, 89000);
        list.addItemAtEnd(1023, "Straightener", 8, 6700);
        list.addItemAtPos(1007, "Laptop", 9, 25000, 2);
        list.displayInventory();
        list.updateQuantity(1007, 20);
        list.removeItem(1023);
        System.out.println("After updates:");
        list.displayInventory();
        list.sortInventoryByName();
        System.out.println("Sorted by Name:");
        list.displayInventory();
    }
}
