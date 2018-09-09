package unity.tests.training.publicsale;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void it_NotEnableForTwoConsecutivesThrows_ForTheSameCustomer() {
        PublicSale publicSale = new PublicSale("Some very expense item");
        Customer aFancyCustomer = new Customer("Mr. Plot");

        publicSale.makeAThrow(new Throw(aFancyCustomer, 2000));
        publicSale.makeAThrow(new Throw(aFancyCustomer, 3000));

        assertEquals(1, publicSale.getThrows().size());
        assertEquals(2000, publicSale.getThrows().get(0).getValue(), DELTA);
    }

    @Test
    public void it_NotEnableMoreThanFiveThrows_FromTheSameCustomer() {
        PublicSale publicSale = new PublicSale("Some very expense item");
        Customer xespirito = new Customer("Xespirito");
        Customer mrRamon = new Customer("Ramon Galdez");

        publicSale.makeAThrow(new Throw(xespirito, 2000));
        publicSale.makeAThrow(new Throw(mrRamon, 3000));
        publicSale.makeAThrow(new Throw(xespirito, 3000));
        publicSale.makeAThrow(new Throw(mrRamon, 3000));
        publicSale.makeAThrow(new Throw(xespirito, 4000));
        publicSale.makeAThrow(new Throw(mrRamon, 3000));
        publicSale.makeAThrow(new Throw(xespirito, 5000));
        publicSale.makeAThrow(new Throw(mrRamon, 3000));
        publicSale.makeAThrow(new Throw(xespirito, 6000));
        publicSale.makeAThrow(new Throw(mrRamon, 999));
        publicSale.makeAThrow(new Throw(xespirito, 7000));

        assertEquals(5, publicSale.getThrows().size());
        int last = publicSale.getThrows().size() - 1;
        assertEquals(4000, publicSale.getThrows().get(last).getValue(), DELTA);
    }

    @Test
    public void it_DobleTheLastThrow() {
        PublicSale publicSale = new PublicSale("Some very expense item");
        Customer xespirito = new Customer("Xespirito");
        Customer mrRamon = new Customer("Ramon Galdez");

        publicSale.makeAThrow(new Throw(xespirito, 4000));
        publicSale.makeAThrow(new Throw(mrRamon, 3000));
        publicSale.doubleTheThrow(xespirito);

        assertEquals(8000, publicSale.getThrows().get(2).getValue(), 0.00001);
    }

}