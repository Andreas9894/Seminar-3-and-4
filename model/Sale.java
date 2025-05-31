package se.kth.iv1350.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.integration.ItemDTO;


/**
 * This class contains a list of itemDTOs, the time of sale of the purchase, total tax and the running total for the purchase.
 */
public class Sale {
    private double runningTotal;
    private double totalTax;
    private LocalDateTime timeOfSale;
    private List <SoldItem> items = new ArrayList<>();
    private List<RevenueObserver> revenueObservers = new ArrayList<>();


    /**
     * Initializes the sale object.
     */
    public Sale () {
        this.items = new ArrayList<>();
        this.timeOfSale = LocalDateTime.now();
        this.totalTax = 0.0;
        this.runningTotal = 0.0;
    }

    /**
     * Adds an item to the list of items and updates the relevant fields
     * @param foundItem is the ItemDTO containing the information of the scanned item.
     */
    public void addItemToItemList  (ItemDTO foundItem) {
        for(SoldItem soldItem : items)
            if(soldItem.getItem().getItemID().equals(foundItem.getItemID()) ){
                soldItem.increaseQuantity();
                runningTotal +=foundItem.getPrice();
                totalTax += foundItem.getPrice()*foundItem.getTaxRate();
                return;
            }
        int quantity = 1;
        items.add(new SoldItem (foundItem, quantity));
        runningTotal += foundItem.getPrice()*quantity;
        totalTax += foundItem.getPrice()* foundItem.getTaxRate();

    }

   /**
     * @return returns the running total.
     */
    public double getRunningTotal () {
        return runningTotal;
    }

    /**
     * @return returns the total tax.
     */
    public double getTotalTax () {
        return totalTax;
    }

    /**
     * @return returns the time of the sale.
     */
    public LocalDateTime getTimeOfSale(){
        return timeOfSale;
    }

    /**
     * @return returns the list of the items 
     */
    public List<SoldItem> getList(){
        return items;
    }
    
    /**
     * @return returns the itemDTO for the item in the specified index.
     */
    public SoldItem getItem(int item){
        return items.get(item);
    }

    /**
     * Adds the time to the sale and notifies the observer.
     * @param sale the object containing information about the sale.
     */
    public  void endSale (Sale sale){
        addFinalTimeOfSale(sale);
        notifyObservers();
    }

    /**
     * Displays the item description, price and running total.
     * @param foundItem the itemDTO for the scanned item.
     */
    public void displaySaleInfo(ItemDTO foundItem){

        System.out.println("Item : " + foundItem.getItemDesc());
        System.out.println("Price : " + foundItem.getPrice());
        System.out.println("Running total : " + runningTotal);
    }

    /**
     * Sets the time in the sale object to the current time.
     * @param sale the object containing information about the sale such as the time of the sale.
     */
     void addFinalTimeOfSale (Sale sale ){
        LocalDateTime timeOfSale = LocalDateTime.now();
    }

    
    public void addRevenueObserver(RevenueObserver obs) {
        revenueObservers.add(obs);
    }

    
    private void notifyObservers() {
        for (RevenueObserver obs : revenueObservers) {
            obs.newRevenue(getRunningTotal());
    }
}

}
