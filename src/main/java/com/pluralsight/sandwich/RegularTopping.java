public class RegularTopping extends Topping {

    public RegularTopping(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(int size) {
        // Implement pricing logic for regular toppings
        return 0.5 * size; // Example: Price increases based on sandwich size
    }
}

