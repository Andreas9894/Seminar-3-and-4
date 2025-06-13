package se.kth.iv1350.model;

import se.kth.iv1350.integration.ItemDTO;

/**
 * contains information about the item being scanned and the running total
 */
public final class SaleDTO{

    private final ItemDTO itemDTO;
    private double runningTotal;



    /**
     * Creates a new instance representing the item being scanned and the running total.
     * @param itemDTO the itemDTO for the specific item being scanned.
     * @param runningTotal the current total cost of the sale.
     */

    public SaleDTO (ItemDTO itemDTO, double runningTotal){

        this.itemDTO = itemDTO;
        this.runningTotal = runningTotal;

    }

    public String getItemDesc () {
        return itemDTO.getItemDesc();
    }
    public double getPrice() {
        return itemDTO.getPrice();
    }

    public double getRunningTotal() {
        return runningTotal;
    }



    
}


