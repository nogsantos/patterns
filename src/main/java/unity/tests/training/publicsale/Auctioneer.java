package unity.tests.training.publicsale;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Auctioneer {

    private double greater = Double.NEGATIVE_INFINITY;
    private double lower = Double.POSITIVE_INFINITY;
    private List<Throw> larger;

    public void evaluate(PublicSale sale) {
        for (Throw athrow : sale.getProposes()) {
            if (athrow.getValue() > greater) {
                greater = athrow.getValue();
            }
            if (athrow.getValue() < greater) {
                lower = athrow.getValue();
            }
        }

        getLargers(sale);
    }

    private void getLargers(PublicSale leilao) {

        larger = new ArrayList<>(leilao.getProposes());

        Collections.sort(larger, (o1, o2) -> {
            if (o1.getValue() < o2.getValue()) return 1;
            if (o1.getValue() > o2.getValue()) return -1;
            return 0;
        });
        larger = larger.subList(0, 3);
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
