package model;

public enum Category {
    ELECTRONICS("Электроника"),
    CLOTHING("Одежда"),
    FOOD("Продукты");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
