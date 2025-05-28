package repository;

import model.Product;
import model.Category;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        // Инициализируем тестовые данные
        products.add(new Product(1, "Ноутбук", 75000, Category.ELECTRONICS));
        products.add(new Product(2, "Футболка", 1200, Category.CLOTHING));
        products.add(new Product(3, "Шоколад", 150, Category.FOOD));
        products.add(new Product(4, "Телефон", 45000, Category.ELECTRONICS));
        products.add(new Product(5, "Джинсы", 3500, Category.CLOTHING));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public List<Product> getProductsByCategory(Category category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                result.add(product);
            }
        }
        return result;
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}