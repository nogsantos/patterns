package unity.tests.training.publicsale;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PublicSaleTest {

    private double DELTA = 0.0001;

    @Test
    public void it_GetTheHigherLance_WhenAPublicSalesOpens() {
        Customer john = new Customer("John");
        Customer yosef = new Customer("Yosef");
        Customer mary = new Customer("Mary");

        PublicSale publicSale = new PublicSale("A new video game");

        publicSale.makeAThrow(new Throw(john, 250));
        publicSale.makeAThrow(new Throw(mary, 300));
        publicSale.makeAThrow(new Throw(yosef, 400));

        Auctioneer auctioneer = new Auctioneer();
        auctioneer.evaluate(publicSale);

        assertEquals(400, auctioneer.getLargerThrow(), DELTA);
    }

}