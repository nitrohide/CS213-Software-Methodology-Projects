package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class Order implements Customizable {
    private final static int FIRSTORDER = 0;
    private static int currID = FIRSTORDER;
    private final static double NJ_TAX_RATE = .06625;

    private int orderID;
    private ObservableList<String> toStringOrder;
    private ArrayList<MenuItem> order;

    public Order() {
        this.orderID = currID++;
        order = new ArrayList<>();
        toStringOrder = FXCollections.observableArrayList();
    }

    @Override
    public boolean add(Object obj) {
        if (obj instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) obj;
            order.add(menuItem);
            toStringOrder.add(menuItem.toString());
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof String) {
            String menuItem = (String) obj;
            for (MenuItem item : order) {
                if (item.toString().equals(menuItem)) {
                    order.remove(item);
                    break;
                }
            }
            toStringOrder.remove(menuItem);
            return true;
        }
        return false;
    }

    public ObservableList<String> getToStringOrder() {
        return toStringOrder;
    }

    public double getSubTotal() {
        double sum = 0;
        for (MenuItem item : order) {
            sum += item.getPrice();
        }
        return sum;
    }

    public double getSalesTax() {
        return getSubTotal() * NJ_TAX_RATE;
    }

    public double getTotal() {
        return getSubTotal() + getSalesTax();
    }

    public int numItems() {
        return order.size();
    }

    public int getID() {
        return this.orderID;
    }
}
