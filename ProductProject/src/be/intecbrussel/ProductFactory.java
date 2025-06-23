package be.intecbrussel;

import java.util.Random;

public class ProductFactory {
    private ProductSorter productSorter;

    private String[] foodProducts = {"Apple", "Steak", "Potatoes", "Salad", "Pear"};
    private String[] healthProducts = {"Face cream", "Vitamins", "Eye drops", "Toothpaste", "Shampoo"};
    private String[] electricProducts = {"Hair dryer", "Vacuum", "Mixer", "Washing machine", "Dishwasher"};

    private Random random = new Random();

    public ProductFactory(ProductSorter productSorter) {
        this.productSorter = productSorter;
    }

    public void createProducts(int amount) {
        int attempts = 0;
        int maxAttempts = amount * 3; // Limiet om te voorkomen dat we blijven proberen

        // Blijf producten maken totdat het gewenste aantal bereikt is, of max attempts bereikt
        while (productSorter.getProductCount() < amount && attempts < maxAttempts) {
            // Kies willekeurig producttype: 0=food, 1=health, 2=electric
            int type = random.nextInt(3);
            // Kies een willekeurige productID tussen 0 en 150
            int id = random.nextInt(151);

            Product product;

            // Afhankelijk van het type kies je een naam uit de juiste array
            switch (type) {
                case 0 -> {
                    String name = foodProducts[random.nextInt(foodProducts.length)];
                    product = new FoodProduct(name, id);
                }
                case 1 -> {
                    String name = healthProducts[random.nextInt(healthProducts.length)];
                    product = new HealthProduct(name, id);
                }
                case 2 -> {
                    String name = electricProducts[random.nextInt(electricProducts.length)];
                    product = new ElectricProduct(name, id);
                }
                default -> throw new IllegalStateException("Unknown product type: " + type);
            }

            // Stuur het product naar de ProductSorter, die checkt op duplicaten
            productSorter.sortProduct(product);

            attempts++; // Tel elke poging
        }
    }
}

