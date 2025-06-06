package model;

public class Product {
    private final int id;
    private final String name;
    private final double price;
    private final Category category;

    public Product(int id, String name, double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return id + ". " + name + " | " + price + " руб | " + category.getDisplayName();
    }
}
