package unity.tests.training.publicsale;

import java.util.Calendar;

public class Payment {

    private Double value;
    private Calendar date;

    public Payment(Double value, Calendar date) {
        this.value = value;
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public Calendar getDate() {
        return date;
    }
}
