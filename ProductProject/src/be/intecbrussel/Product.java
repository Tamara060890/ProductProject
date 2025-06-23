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
    public boolean equals(Object o) {
        if (this == o) return true;  // zelfde object
        if (!(o instanceof Product product)) return false; // check type
        return productID == product.productID; // vergelijk id's
    }

    @Override
    public int hashCode() {
        return productID;
    }

    @Override
    public String toString() {
        return "Naam: " + name +" , productId = " + productID;
    }
}

