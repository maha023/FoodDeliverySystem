
package fooddelivery;

public class Main {

    public static void main(String[] args) {

        // First order
        Order order1 = new Order("Sara", new ExpressDelivery());

        order1.addItem(new Meal("Burger", 8.0, 1), 2);
        order1.addItem(new Drink("Juice", 3.0, true));

        System.out.println("Order 1 subtotal: " + order1.getSubtotal());
        System.out.println("Order 1 total: " + order1.getTotal());

        order1.pay(new CardPayment());
        order1.deliver();

        System.out.println();

        // Second order
        Order order2 = new Order("Ahmad", new StandardDelivery());

        order2.addItem(new Meal("Pizza", 10.0, 2), 3);
        order2.addItem(new Drink("Water", 2.0, false), 2);

        System.out.println("Order 2 subtotal: " + order2.getSubtotal());
        System.out.println("Order 2 total: " + order2.getTotal());

        order2.pay(new CashPayment());
        order2.deliver();
    }
}
