package unity.tests.training.publicsale;

import java.util.Calendar;

public class SystemTimer implements Timer {
    @Override
    public Calendar today() {
        return Calendar.getInstance();
    }
}
