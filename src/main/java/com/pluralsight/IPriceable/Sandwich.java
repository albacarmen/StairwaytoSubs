package IPriceable;

import com.pluralsight.sandwich.Cheese;
import com.pluralsight.sandwich.Sauces;
import com.pluralsight.sandwich.Meat;
import com.pluralsight.sandwich.RegularTopping;
import com.pluralsight.sandwich.Sauces;

import java.util.List;

public class Sandwich implements IPriceable {
    private String bread;
    private int size;
    private List<Meat> meats;
    private List<Sauces> sauces;
    private List<RegularTopping> regularToppings;
    private List<Cheese> cheeses;
    private boolean isToasted;

    public Sandwich(String bread, int size, List<Meat> meats, List<Sauce> sauces,
                    List<RegularTopping> regularToppings, List<Cheese> cheeses, boolean isToasted) {
        this.bread = bread;
        this.size = size;
        this.meats = meats;
        this.sauces = sauces;
        this.regularToppings = regularToppings;
        this.cheeses = cheeses;
        this.isToasted = isToasted;
    }

    public String getBread() {
        return bread;
    }

    public int getSize() {
        return size;
    }

    public List<Meat> getMeats() {
        return meats;
    }

    public List<Sauce> getSauces() {
        return sauces;
    }

    public List<RegularTopping> getRegularToppings() {
        return regularToppings;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }

    public boolean isToasted() {
        return isToasted;
    }
}

    @Override
    public double getPrice() {

        double price = 19.0; // base price
        for (Topping topping : toppings) {
            price += topping.calculatePrice(size);
        }
        return price;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "bread='" + bread + '\'' +
                ", size=" + size +
                ", toppings=" + toppings +
                ", isToasted=" + isToasted +
                '}';
    }
}


