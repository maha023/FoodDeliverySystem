
package fooddelivery;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private static int counter = 1000;

    private int orderNumber;
    private String customerName;
    private List<OrderLine> lines;
    private OrderStatus status;
    private DeliveryOption delivery;

    public Order(String customerName, DeliveryOption delivery) {
        this.orderNumber = ++counter;
        this.customerName = customerName;
        this.delivery = delivery;
        this.lines = new ArrayList<>();
        this.status = OrderStatus.NEW;
    }

    public void addItem(MenuItem item) {
        addItem(item, 1);
    }

    public void addItem(MenuItem item, int qty) {
        if (status == OrderStatus.NEW && qty > 0) {
            lines.add(new OrderLine(item, qty));
        }
    }

    public double getSubtotal() {
        double subtotal = 0;

        for (OrderLine line : lines) {
            subtotal += line.getLineTotal();
        }

        return subtotal;
    }

    public double getTotal() {
        return getSubtotal() + delivery.getFee();
    }

    public void pay(PaymentMethod method) {
        if (status == OrderStatus.NEW) {
            double amount = method.pay(getTotal());
            System.out.println("Amount paid: " + amount);
            status = OrderStatus.PAID;
        }
    }

    public void deliver() {
        if (status == OrderStatus.PAID) {
            status = OrderStatus.DELIVERED;
        }
    }

    public void cancel() {
        if (status == OrderStatus.NEW) {
            status = OrderStatus.CANCELLED;
        }
    }
}
