package sample;
/**
 * menuitem is the parent type for donut and coffee
 *
 * @author Anuraj Dubey, Chenghao Lin
 */
public class MenuItem {
    private double price;

    /**
     * sets the price of the object
     * @param price of the object
     */
    public void setPrice(double price){
        this.price = price;
    }

    /**
     * gets the price of the object
     * @return price of the object
     */
    public double getPrice(){
        return this.price;
    }
}
