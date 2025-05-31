package se.kth.iv1350.integration;

import java.util.List;

import se.kth.iv1350.model.Sale;
import se.kth.iv1350.model.SoldItem;

/**
 * Class responsible for the printing of the receipt. 
 */
public class Printer {

    /**
     * Method responsible for formatting and printing the receipt with all the required information. 
     * @param amountPaid is the amount of money paid by the customer.
     * @param change is the amount of money to give back to the customer.
     * @param sale is the list of items with details of the purchase.
     */

    public void printReceipt (double amountPaid, double change, Sale sale) {

        System.out.println("---RECEIPT---");
        System.out.println("Time: " + sale.getTimeOfSale());
        List <SoldItem> items = sale.getList();

        for(SoldItem soldItem : items) {
            ItemDTO item = soldItem.getItem();
            System.out.println("Item : " + item.getItemDesc());
            System.out.println("Quantity : " + soldItem.getQuantity());
            System.out.println("Price per item : " + item.getPrice());
            System.out.println("Sum : " + soldItem.getTotalPrice());
        }

    System.out.println("Total with tax: " + sale.getRunningTotal());
    System.out.println("Total Tax: " + sale.getTotalTax());
    System.out.println("Amount Paid: " + amountPaid);
    System.out.println("Change: " + change);
    }

}
