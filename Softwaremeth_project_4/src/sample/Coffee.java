package sample;

import javafx.util.Pair;
import java.util.ArrayList;

/**
 * Coffee class that defines the object
 *
 * @author Anuraj Dubey, Chenghao Lin
 */
public class Coffee extends MenuItem implements Customizable{
    private static final double MIN_COST = 1.99;
    private static final double SIZE_INCREASE_COST = 0.50;
    private static final double ADDIN_COST = 0.20;
    private ArrayList<Pair<String, Integer>> addIns;
    private String size;
    private int quantity;

    /**
     * Coffee constructor, initializes object
     */
    public Coffee() {
        this.addIns = new ArrayList<>();
        this.size = null;
        this.quantity = 0;
    }

    /**
     * adds the add-ins to the coffee object
     * @param obj of add-in
     * @return true if successfully added, false otherwise
     */
    @Override
    public boolean add(Object obj) {
        boolean added;
        if (obj instanceof Pair) {
            Pair<String, Integer> pair = (Pair) obj;
            addIns.add(pair);
            added = true;
        }
        else{
            added = false;
        }
        return added;
    }

    /**
     * Removes add-in from the object
     * @param obj the add-in that is being removed
     * @return true if remove successful, false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        boolean removed;
        if (obj instanceof Pair) {
            Pair toRemove = (Pair) obj;
            removed = this.addIns.remove(toRemove);
        }
        else{
            removed = false;
        }
        return removed;
    }

    /**
     * returns the item price of the coffee after size,quantity, and addins are gathered
     * @return sub-total of the coffee before tax
     */
    public double itemPrice() {
        double price = 0;
        if (this.size != null) {
            switch (this.size) {
                case "Short" :
                    price += MIN_COST;
                case "Tall" :
                    price += MIN_COST + SIZE_INCREASE_COST;
                case "Grande" :
                    price += MIN_COST + (SIZE_INCREASE_COST * 2);
                case "Venti" :
                    price += MIN_COST + (SIZE_INCREASE_COST * 3);
            }
        } else {
            price = 0;
        }
        for (Pair pair : addIns) {
            int quantity = (int) pair.getValue();
            price += quantity * ADDIN_COST;
        }

        price *= quantity;

        super.setPrice(price);
        return super.getPrice();
    }

    /**
     * makes the coffee object into string format to be displayed
     * @return string format of the coffee object
     */
    @Override
    public String toString() {
        String coffeeString = "Coffee, ";
        for (Pair pair : addIns) {
            coffeeString += pair.getKey() + ": " + pair.getValue() + ",";
        }
        coffeeString += "Size: " + this.size + ", Quantity: " + this.quantity;

        return coffeeString;
    }

    /**
     * setter method to set the size of the coffee
     * @param size of the coffee object
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * setter method to set the number of coffees ordered
     * @param quantity of coffee ordered
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
