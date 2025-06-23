package be.intecbrussel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductSorter {
    private List<Product> products = new ArrayList<>();
    private List<FoodProduct> foodProducts = new ArrayList<>();
    private List<HealthProduct> healthProducts = new ArrayList<>();
    private List<ElectricProduct> electricProducts = new ArrayList<>();
    // Set om alle gebruikte productID's bij te houden, zodat we duplicaten kunnen voorkomen
    private Set<Integer> usedIDs = new HashSet<>();

    public List<FoodProduct> getFoodProducts() {
        return foodProducts;
    }

    public List<HealthProduct> getHealthProducts() {
        return healthProducts;
    }

    public List<ElectricProduct> getElectricProducts() {
        return electricProducts;
    }

    // Geeft het totaal aantal producten terug dat is toegevoegd.
    public int getProductCount() {
        return products.size();
    }

    //Methode om een product te sorteren en toe te voegen aan de juiste lijsten.
    //Controleert eerst of het productID al bestaat, om duplicaten te voorkomen.
    public void sortProduct(Product product) {
        int id = product.getProductID();
        // Check of dit productID al in gebruik is
        if (usedIDs.contains(id)) {
            return; // Product met deze ID bestaat al, dus niet toevoegen
        }

        // Voeg het nieuwe productID toe aan de set om duplicaten in de toekomst te voorkomen
        usedIDs.add(id);

        // Voeg het product toe aan de algemene lijst
        products.add(product);

        // Voeg het product ook toe aan de juiste sublijst, afhankelijk van het type
        if (product instanceof FoodProduct food) {
            foodProducts.add(food);
        } else if (product instanceof HealthProduct health) {
            healthProducts.add(health);
        } else if (product instanceof ElectricProduct electric) {
            electricProducts.add(electric);
        }
    }
}

