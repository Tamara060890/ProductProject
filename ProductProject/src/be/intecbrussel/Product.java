package be.intecbrussel;

public abstract class Product {
    private String name;
    private int productID;

    public Product(String name, int productID) {
        this.name = name;
        this.productID = productID;
    }

    public int getProductID() {
        return productID;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - ID: " + productID + ", Name: " + name;
    }
}

