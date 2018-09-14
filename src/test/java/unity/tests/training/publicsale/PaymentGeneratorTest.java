package unity.tests.training.publicsale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PaymentGeneratorTest {

    @Mock
    PaymentRepository paymentRepository;
    @Mock
    Auctioneer auctioneer;
    @Mock
    Timer clock;

    @Test
    public void itReturnTheNextBusinessDayWhenCurrentDayIsOnWeekend() {

        Calendar saturday = Calendar.getInstance();
        saturday.set(2018, Calendar.SEPTEMBER, 1);

        PublicSale sale = new PublicSale("Test");
        sale.makeAThrow(new Throw(new Customer("One"), 100));
        sale.makeAThrow(new Throw(new Customer("Two"), 200));
        sale.makeAThrow(new Throw(new Customer("Three"), 300));

        List<PublicSale> sales = new ArrayList<>();
        sales.add(sale);

        when(clock.today()).thenReturn(saturday);

        PaymentGenerator paymentGenerator = new PaymentGenerator(paymentRepository, auctioneer, clock);
        paymentGenerator.generate(sales);

        ArgumentCaptor<Payment> captor = ArgumentCaptor.forClass(Payment.class);
        verify(paymentRepository).save(captor.capture());

        Payment generatedPayment = captor.getValue();

        assertEquals(Calendar.MONDAY, generatedPayment.getDate().get(Calendar.DAY_OF_WEEK));
        assertEquals(3, generatedPayment.getDate().get(Calendar.DAY_OF_MONTH));
    }

}