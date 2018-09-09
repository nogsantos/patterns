package unity.tests.training.publicsale;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AuctioneerTest {

    private double DELTA = 0.0001;

    private Customer john;
    private Customer yosef;
    private Customer mary;
    private PublicSale publicSale;


    @Before
    public void setUp() {
        john = new Customer("John");
        yosef = new Customer("Yosef");
        mary = new Customer("Mary");
        publicSale = new PublicSale("A new video game");
    }

    @Test
    public void it_GetTheHigherThrow_WhenAPublicSalesOpens() {

        publicSale.makeAThrow(new Throw(john, 250));
        publicSale.makeAThrow(new Throw(mary, 300));
        publicSale.makeAThrow(new Throw(yosef, 400));

        Auctioneer auctioneer = new Auctioneer();
        auctioneer.evaluate(publicSale);

        assertEquals(400, auctioneer.getLargerThrow(), DELTA);
    }

    @Test
    public void it_GetTheThreeHigherThrow_WhenReceiverAnOrderingAscThrows() {

        publicSale.makeAThrow(new Throw(john, 100));
        publicSale.makeAThrow(new Throw(mary, 200));
        publicSale.makeAThrow(new Throw(john, 300));
        publicSale.makeAThrow(new Throw(mary, 400));

        Auctioneer auctioneer = new Auctioneer();
        auctioneer.evaluate(publicSale);

        List<Throw> largers = auctioneer.getThreeLargers();

        assertEquals(3, largers.size());
        assertEquals(400, largers.get(0).getValue(), DELTA);
        assertEquals(300, largers.get(1).getValue(), DELTA);
        assertEquals(200, largers.get(2).getValue(), DELTA);
    }

    @Test
    public void it_GetsAllThrows_WhenHasLessThanThreeThrows() {

        publicSale.makeAThrow(new Throw(john, 100));
        publicSale.makeAThrow(new Throw(mary, 200));

        Auctioneer auctioneer = new Auctioneer();
        auctioneer.evaluate(publicSale);

        List<Throw> largers = auctioneer.getThreeLargers();

        assertEquals(2, largers.size());
        assertEquals(200, largers.get(0).getValue(), DELTA);
        assertEquals(100, largers.get(1).getValue(), DELTA);
    }

    @Test
    public void it_GetAnEmptyList_WhenHasNoThrows() {

        Auctioneer auctioneer = new Auctioneer();
        auctioneer.evaluate(publicSale);

        List<Throw> largers = auctioneer.getThreeLargers();

        assertEquals(0, largers.size());
    }

}