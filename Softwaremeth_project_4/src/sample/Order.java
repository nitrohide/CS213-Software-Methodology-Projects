package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Order object that holds all the items in the current order
 *
 * @author Anuraj Dubey, Chenghao Lin
 */
public class Order implements Customizable {
    private final static int FIRSTORDER = 0;
    private static int currID = FIRSTORDER;
    private final static double NJ_TAX_RATE = .06625;

    private int orderID;
    private ObservableList<String> toStringOrder;
    private ArrayList<MenuItem> order;

    /**
     * Constructor for the order object
     */
    public Order() {
        this.orderID = currID++;
        order = new ArrayList<>();
        toStringOrder = FXCollections.observableArrayList();
    }

    /**
     * Adds a menuitem object to the current order
     * @param obj to be added to the order
     * @return true if menuitem is added, false otherwise
     */
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

    /**
     *  Remove a menuitem object to the current order
     * @param obj to be removed from the order
     * @return True if menuItem is removed, false otherwise
     */
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

    /**
     * Gets the subtotal price of the entire order
     * @return subtotal price of entire order
     */
    public double getSubTotal() {
        double sum = 0;
        for (MenuItem item : order) {
            sum += item.getPrice();
        }
        return sum;
    }

    /**
     * Calculates the sales tax with the NJ tax rate with the subtotal of the order
     * @return the sales tax of the order
     */
    public double getSalesTax() {
        return getSubTotal() * NJ_TAX_RATE;
    }

    /**
     * calculates the total cost of the order with subtotal+salestax
     * @return
     */
    public double getTotal() {
        return getSubTotal() + getSalesTax();
    }

    /**
     * finds the number of items in the order
     * @return the number of items in the order
     */
    public int numItems() {
        return order.size();
    }

    /**
     * to find the ID of the order
     * @return the ordernumber or the orderID, uniquely identifying the order
     */
    public int getID() {
        return this.orderID;
    }
}
