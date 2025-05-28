package service;

import model.Order;
import model.OrderStatus;

public class DeliveryService {
    public void deliver(Order order) {
        order.setStatus(OrderStatus.DELIVERING);
        System.out.println("Заказ #" + order.getOrderId() + " отправлен в доставку.");
    }

    public void complete(Order order) {
        order.setStatus(OrderStatus.DELIVERED);
        System.out.println("Заказ #" + order.getOrderId() + " успешно доставлен.");
    }

    public void returnOrder(Order order) {
        order.setStatus(OrderStatus.RETURNED);
        System.out.println("Заказ #" + order.getOrderId() + " возвращён.");
    }
}