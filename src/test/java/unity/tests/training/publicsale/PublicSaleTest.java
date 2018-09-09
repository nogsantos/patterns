package unity.tests.training.publicsale;

import org.junit.Test;

import static org.junit.Assert.*;

public class PublicSaleTest {

    private static double DELTA = 0.00001;

    @Test
    public void it_ShouldReceiveAThrow() {

        PublicSale publicSale = new PublicSale("Some very expense item");
        assertEquals(0, publicSale.getThrows().size());

        publicSale.makeAThrow(new Throw(new Customer("Ramon Galdez"), 5000.55));
        assertEquals(1, publicSale.getThrows().size());
        assertEquals(5000.55, publicSale.getThrows().get(0).getValue(), 0.00001);
    }

    @Test
    public void it_ShouldReceiveManyThrows() {

        PublicSale publicSale = new PublicSale("Some very expense item");
        publicSale.makeAThrow(new Throw(new Customer("Xespirito"), 4000.55));
        publicSale.makeAThrow(new Throw(new Customer("Ramon Galdez"), 5000.55));

        assertEquals(2, publicSale.getThrows().size());
        assertEquals(4000.55, publicSale.getThrows().get(0).getValue(), DELTA);
        assertEquals(5000.55, publicSale.getThrows().get(1).getValue(), DELTA);
    }


}