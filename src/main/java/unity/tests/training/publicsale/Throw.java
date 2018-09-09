package unity.tests.training.publicsale;

public class Throw {

    private Customer customer;
    private double value;

    public Throw(Customer customer, double value) {
        this.customer = customer;
        this.value = value;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getValue() {
        return value;
    }
}
