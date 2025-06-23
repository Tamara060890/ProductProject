package be.intecbrussel;

public class MainApp {
    public static void main(String[] args) {
        ProductSorter sorter = new ProductSorter();
        ProductFactory factory = new ProductFactory(sorter);

        factory.createProducts(100);

        System.out.println("Aantal unieke producten: " + sorter.getProductCount());

        System.out.println("\n--- Food Products ---");
        sorter.getFoodProducts().forEach(System.out::println);

        System.out.println("\n--- Health Products ---");
        sorter.getHealthProducts().forEach(System.out::println);

        System.out.println("\n--- Electric Products ---");
        sorter.getElectricProducts().forEach(System.out::println);

        // Een nieuw product aanmaken en toevoegen
        FoodProduct extraFood = new FoodProduct("Banana", 20);
        sorter.sortProduct(extraFood);

        System.out.println("Er zijn " + sorter.getProductCount()+ " producten");

    }
}

