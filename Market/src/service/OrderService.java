package service;

import model.Order;
import model.Product;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final List<Order> orders = new ArrayList<>();
    private int nextOrderId = 1;

    public Order createOrder() {
        Order order = new Order(nextOrderId++);
        orders.add(order);
        return order;
    }

    public void repeatOrder(Order oldOrder) {
        Order newOrder = createOrder();
        for (Product product : oldOrder.getProducts()) {
            newOrder.addProduct(product);
        }
        System.out.println("Повторен заказ #" + newOrder.getOrderId());
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }
}