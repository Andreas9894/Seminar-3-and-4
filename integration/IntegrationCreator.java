package se.kth.iv1350.integration;

/**
 * This class is responsible for the creation of the three external systems.
 */
public class IntegrationCreator {
    private ExternalInventorySystem extInvSys = new ExternalInventorySystem();
    private ExternalAccountingSystem extAccSys = new ExternalAccountingSystem ();
    private DiscountDatabase discountDB = new DiscountDatabase();

     /**
     * @return passes the instantiated ExternalInventorySystem back.
     */
    public ExternalInventorySystem getExternalInventorySystem() {

        return extInvSys;
    }

    /**
     * @return passes the instantiated ExternalAccountingSystem back.
     */
    public ExternalAccountingSystem getExternalAccountingSystem () {

        return extAccSys;
    }

    /**
     * @return passes the instantiated DiscountDatabase back.
     */
    public DiscountDatabase getDiscountDatabase() {
        
        return discountDB;
    }


        
}
