package model;

public enum OrderStatus {
    CREATED("Создан"),
    PROCESSING("В обработке"),
    DELIVERING("Доставляется"),
    DELIVERED("Доставлен"),
    RETURNED("Возвращён");

    private final String displayName;

    OrderStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
