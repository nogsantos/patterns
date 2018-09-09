package unity.tests.training.publicsale;

import java.util.ArrayList;
import java.util.List;

public class PublicSale {

    private String item;

    private List<Throw> proposes = new ArrayList<>();

    public PublicSale(String item) {
        this.item = item;
    }

    public void makeAThrow(Throw aThrow) {
        this.proposes.add(aThrow);
    }

    public List<Throw> getProposes() {
        return proposes;
    }
}
