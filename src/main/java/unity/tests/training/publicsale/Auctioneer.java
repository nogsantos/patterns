package unity.tests.training.publicsale;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Auctioneer {

    private double greater = Double.NEGATIVE_INFINITY;
    private double lower = Double.POSITIVE_INFINITY;
    private List<Throw> larger;

    public void evaluate(PublicSale sale) {
        for (Throw athrow : sale.getThrows()) {
            if (athrow.getValue() > greater) {
                greater = athrow.getValue();
            }
            if (athrow.getValue() < greater) {
                lower = athrow.getValue();
            }
        }

        getLargers(sale);
    }

    private void getLargers(PublicSale publicSale) {

        larger = new ArrayList<>(publicSale.getThrows());

        Collections.sort(larger, (o1, o2) -> {
            if (o1.getValue() < o2.getValue()) {
                return 1;
            }
            if (o1.getValue() > o2.getValue()) {
                return -1;
            }
            return 0;
        });
        larger = larger.subList(0, larger.size() > 3 ? 3 : larger.size());
    }

    public List<Throw> getThreeLargers() {
        return this.larger;
    }

    public double getLargerThrow() {
        return greater;
    }

    public double getLowerThrow() {
        return lower;
    }
}
