package util;

import java.util.List;
import java.util.Scanner;
import model.Order;
import model.Category;
import model.Product;

public class ConsoleMenu {
    private final Scanner scanner = new Scanner(System.in);

    public void showMainMenu() {
        System.out.println("\n=== МАГАЗИН ===");
        System.out.println("1. Посмотреть товары");
        System.out.println("2. Новый заказ");
        System.out.println("3. Просмотреть заказы");
        System.out.println("4. Отследить доставку");
        System.out.println("5. Вернуть заказ");
        System.out.println("6. Повтор заказа");
        System.out.println("0. Выход");
    }

    public void showCategories() {
        System.out.println("Выберите категорию:");
        for (Category c : Category.values()) {
            System.out.println((c.ordinal() + 1) + ". " + c.getDisplayName());
        }
        System.out.println("0. Все");
    }

    public int getUserChoice(int maxOption) {
        int choice = -1;
        while (choice < 0 || choice > maxOption) {
            System.out.print("Введите ваш выбор: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {}
        }
        return choice;
    }

    public void showProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Товаров нет.");
        } else {
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }

    public void showOrders(List<Order> orders) {
        if (orders.isEmpty()) {
            System.out.println("Заказов нет.");
        } else {
            for (Order o : orders) {
                System.out.println(o);
            }
        }
    }

    public int askForProductId() {
        System.out.print("Введите ID товара для добавления в корзину (0 — закончить): ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int askForOrderId() {
        System.out.print("Введите номер заказа: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void pressEnterToContinue() {
        System.out.println("Нажмите Enter чтобы продолжить...");
        scanner.nextLine();
    }
}