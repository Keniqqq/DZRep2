package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int orderId;
    private final List<Product> products = new ArrayList<>();
    private OrderStatus status = OrderStatus.CREATED;

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public String toString() {
        return "Заказ #" + orderId + ", товаров: " + products.size() + ", на сумму: " + getTotalPrice() + " руб, статус: " + status;
    }
}