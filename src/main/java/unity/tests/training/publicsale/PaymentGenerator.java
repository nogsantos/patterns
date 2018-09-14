package unity.tests.training.publicsale;

import java.util.Calendar;
import java.util.List;

public class PaymentGenerator {


    private PaymentRepository payments;
    private Auctioneer auctioneer;
    private Timer timer;

    public PaymentGenerator(PaymentRepository payments, Auctioneer auctioneer, Timer timer) {
        this.payments = payments;
        this.auctioneer = auctioneer;
        this.timer = timer;
    }

    public void generate(List<PublicSale> sales) {
        for (PublicSale sale : sales) {
            auctioneer.evaluate(sale);
            Payment newPayment = new Payment(auctioneer.getLargerThrow(), nextBusinessDay());
            payments.save(newPayment);
        }
    }

    /**
     * Return next business day when current day is on weekend
     *
     * @return First business Day
     */
    private Calendar nextBusinessDay() {
        Calendar date = timer.today();
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);

        if (dayOfWeek == Calendar.SATURDAY) {
            date.add(Calendar.DAY_OF_MONTH, 2);
        } else if (dayOfWeek == Calendar.SUNDAY) {
            date.add(Calendar.DAY_OF_MONTH, 1);
        }
        return date;
    }
}
