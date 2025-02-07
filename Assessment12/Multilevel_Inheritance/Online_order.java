import java.util.*;

class Order {
    int orderId;
    String orderDate;
    
    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    
   
    
    String getOrderStatus() {
        return "Order Placed with id :"+orderId;
    }
}

class ShippedOrder extends Order {
    int trackingNumber;
    
    ShippedOrder(int orderId, String orderDate, int trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    
    @Override
    String getOrderStatus() {
        return "Order Shipped - Tracking Number: " + trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;
    
    DeliveredOrder(int orderId, String orderDate, int trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    
    @Override
    String getOrderStatus() {
        return "Order Delivered on " + deliveryDate;
    }
}

public class Main {
    public static void main(String[] args) {
        Order order = new Order(101, "2025-02-07");
        ShippedOrder shippedOrder = new ShippedOrder(101, "2025-02-06", 123456);
        DeliveredOrder deliveredOrder = new DeliveredOrder(101, "2025-02-05", 654321, "2025-02-07");
        
        System.out.println(order.getOrderStatus());
        System.out.println(shippedOrder.getOrderStatus());
        System.out.println(deliveredOrder.getOrderStatus());
    }
}
