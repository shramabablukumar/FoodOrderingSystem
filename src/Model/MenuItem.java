package Model;

public class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        if (price <= 0) throw new IllegalArgumentException("Invalid price");
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setPrice(double price) {
        if (price <= 0) throw new IllegalArgumentException("Invalid price");
        this.price = price;
    }
}