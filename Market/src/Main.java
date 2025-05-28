import java.util.*;
import model.Product;
import model.Order;
import repository.ProductRepository;
import service.OrderService;
import service.DeliveryService;
import util.ConsoleMenu;
import model.Category;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepo = new ProductRepository();
        OrderService orderService = new OrderService();
        DeliveryService deliveryService = new DeliveryService();
        ConsoleMenu menu = new ConsoleMenu();

        while (true) {
            menu.showMainMenu();
            int choice = menu.getUserChoice(6);

            switch (choice) {
                case 1 -> {
                    menu.showCategories();
                    int catChoice = menu.getUserChoice(Category.values().length);
                    List<Product> filtered = switch (catChoice) {
                        case 1 -> productRepo.getProductsByCategory(Category.ELECTRONICS);
                        case 2 -> productRepo.getProductsByCategory(Category.CLOTHING);
                        case 3 -> productRepo.getProductsByCategory(Category.FOOD);
                        default -> productRepo.getAllProducts();
                    };
                    menu.showProducts(filtered);
                    menu.pressEnterToContinue();
                }

                case 2 -> {
                    Order order = orderService.createOrder();
                    while (true) {
                        menu.showProducts(productRepo.getAllProducts());
                        int productId = menu.askForProductId();
                        if (productId == 0) break;
                        Product product = productRepo.getProductById(productId);
                        if (product != null) {
                            order.addProduct(product);
                            System.out.println("Добавлено: " + product.getName());
                        } else {
                            System.out.println("Товар не найден.");
                        }
                    }
                    deliveryService.deliver(order);
                    deliveryService.complete(order);
                }

                case 3 -> {
                    menu.showOrders(orderService.getOrders());
                    menu.pressEnterToContinue();
                }

                case 4 -> {
                    menu.showOrders(orderService.getOrders());
                    int orderId = menu.askForOrderId();
                    Order order = orderService.getOrders().stream()
                            .filter(o -> o.getOrderId() == orderId)
                            .findFirst()
                            .orElse(null);
                    if (order != null) {
                        System.out.println("Статус заказа: " + order.getStatus());
                    } else {
                        System.out.println("Заказ не найден.");
                    }
                    menu.pressEnterToContinue();
                }

                case 5 -> {
                    menu.showOrders(orderService.getOrders());
                    int orderId = menu.askForOrderId();
                    Order order = orderService.getOrders().stream()
                            .filter(o -> o.getOrderId() == orderId)
                            .findFirst()
                            .orElse(null);
                    if (order != null) {
                        deliveryService.returnOrder(order);
                    } else {
                        System.out.println("Заказ не найден.");
                    }
                    menu.pressEnterToContinue();
                }

                case 6 -> {
                    List<Order> orders = orderService.getOrders();
                    if (!orders.isEmpty()) {
                        Order last = orders.get(orders.size() - 1);
                        orderService.repeatOrder(last);
                    } else {
                        System.out.println("Нет предыдущих заказов.");
                    }
                    menu.pressEnterToContinue();
                }

                case 0 -> {
                    System.out.println("До свидания!");
                    return;
                }
            }
        }
    }
}