package se.kth.iv1350.model;

import se.kth.iv1350.integration.ItemDTO;

/**
 * This class is used to store the ItemDTO and the quantity of each item.
 */
public class SoldItem {

    private final ItemDTO item;
    private int quantityPurchased;

    /**
     * Initializes the soldItem object
     * @param item the itemDTO of a specific item.
     * @param quantityPurchased the quantity of the item.
     */
    public SoldItem (ItemDTO item, int quantityPurchased){
        this.item = item;
        this.quantityPurchased = quantityPurchased;
    }
    
    /**
     * @return returns the itemDTO.
     */
    public ItemDTO getItem(){
        return item;
    }

    /**
     * 
     * @return returns the quantity of the item.
     */
    public int getQuantity(){
        return quantityPurchased;
    }

    /**
     * @return returns the price of the item adjusted for the quantity.
     */
    public double getTotalPrice (){
        return item.getPrice()* quantityPurchased;
    }

    /**
     * @return returns the total tax amount of the items.
     */
    public double getTotalTax(){
        return item.getPrice()* item.getTaxRate()*quantityPurchased;
    }
    
    /**
     * Increases the quantity of the item by 1.
     */
    public void increaseQuantity(){
        quantityPurchased++;
    }
    

}
