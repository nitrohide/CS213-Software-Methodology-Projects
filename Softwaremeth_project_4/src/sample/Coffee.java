package sample;

import javafx.util.Pair;
import java.util.ArrayList;

public class Coffee extends MenuItem implements Customizable{
    private static final double MIN_COST = 1.99;
    private static final double SIZE_INCREASE_COST = 0.50;
    /*
    private static final double TALL_COST = 2.49;
    private static final double GRANDE_COST = 2.99;
    private static final double VENTI_COST = 3.49;*/

    private static final double ADDIN_COST = 0.20;

    private ArrayList<Pair<String, Integer>> addIns;
    private String size;
    private int quantity;

    public Coffee() {
        this.addIns = new ArrayList<>();
        this.size = null;
        this.quantity = 0;
    }

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

    public double itemPrice() {
        double price = 0;
        if (this.size != null) {
            switch (this.size) {
                case "Short" -> price += MIN_COST;
                case "Tall" -> price += MIN_COST + SIZE_INCREASE_COST;
                case "Grande" -> price += MIN_COST + (SIZE_INCREASE_COST * 2);
                case "Venti" -> price += MIN_COST + (SIZE_INCREASE_COST * 3);
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

    @Override
    public String toString() {
        String coffeeString = "Coffee, ";
        for (Pair pair : addIns) {
            coffeeString += pair.getKey() + ": " + pair.getValue() + ",";
        }
        coffeeString += "Size: " + this.size + ", Quantity: " + this.quantity;

        return coffeeString;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
