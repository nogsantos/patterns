package unity.tests.training.publicsale;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PublicSale {

    private String description;

    private List<Throw> theThrows = new ArrayList<>();

    public PublicSale(String description) {
        this.description = description;
    }

    public void makeAThrow(Throw aThrow) {
        this.theThrows.add(aThrow);
    }

    public List<Throw> getThrows() {
        return Collections.unmodifiableList(theThrows);
    }
}
