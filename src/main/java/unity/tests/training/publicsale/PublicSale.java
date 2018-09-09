package unity.tests.training.publicsale;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PublicSale {

    private String description;

    private List<Throw> listOfThrows = new ArrayList<>();

    public PublicSale(String description) {
        this.description = description;
    }

    public void makeAThrow(Throw aThrow) {
        if (listOfThrows.isEmpty() || canGiveAThrow(aThrow.getCustomer())) {
            listOfThrows.add(aThrow);
        }
    }

    public List<Throw> getThrows() {
        return Collections.unmodifiableList(listOfThrows);
    }

    public void doubleTheThrow(Customer customer) {
        Optional<Throw> last = listOfThrows.stream().filter(theThrow ->
                theThrow.getCustomer().equals(customer)
        ).findFirst();
        Throw toDouble = last.get();
        makeAThrow(new Throw(customer, toDouble.getValue() * 2));
    }

    private boolean canGiveAThrow(Customer customer) {
        return !lastGivedThrow().getCustomer().equals(customer) && sizeOfCustomerThrow(customer) < 5;
    }

    private long sizeOfCustomerThrow(Customer customer) {
        return listOfThrows.stream().map(aThrow -> aThrow.getCustomer().equals(customer)).count();
    }

    private Throw lastGivedThrow() {
        return listOfThrows.get(listOfThrows.size() - 1);
    }
}
