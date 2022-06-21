package personalfinance.model;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Filter {

    public static final int STEP_DAY = 0;
    public static final int STEP_MONTH = 1;
    public static final int STEP_YEAR = 2;

    private int step;
    private Date from;
    private Date to;

    public Filter() {
        this(STEP_MONTH);
    }

    public Filter(int step) {
        this.step = step;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
        setFromTo(new GregorianCalendar());
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    public void next() {
        offset(1);
    }

    public void prev() {
        offset(-1);
    }

    public void nextPeriod() {
        ++step;
        if (step > STEP_YEAR) step = STEP_DAY;
        setFromTo(new GregorianCalendar());
    }

    public boolean check(Date date) {
        return date.compareTo(from) >= 0 && date.compareTo(to) <= 0;
    }

    private void setFromTo(Calendar calendar) {
        int thisYear = calendar.get(Calendar.YEAR);
        int thisMonth = calendar.get(Calendar.MONTH);
        int thisDay = calendar.get(Calendar.DAY_OF_MONTH);
        switch (step) {
            case STEP_DAY:
                this.from = new GregorianCalendar(
                        thisYear,
                        thisMonth,
                        thisDay,
                        0, 0, 0
                ).getTime();
                this.to = new GregorianCalendar(
                        thisYear,
                        thisMonth,
                        thisDay,
                        23, 59, 59
                ).getTime();
                break;
            case STEP_MONTH:
                YearMonth yearMonth = YearMonth.of(calendar.get(Calendar.YEAR), Calendar.MONTH);
                this.from = new GregorianCalendar(
                        thisYear,
                        thisMonth,
                        1,
                        0, 0, 0
                ).getTime();
                this.to = new GregorianCalendar(
                        thisYear,
                        thisMonth,
                        yearMonth.lengthOfMonth(),
                        23, 59, 59
                ).getTime();
                break;
            case STEP_YEAR:
                this.from = new GregorianCalendar(
                        thisYear,
                        Calendar.JANUARY,
                        1,
                        0, 0, 0
                ).getTime();
                this.to = new GregorianCalendar(
                        thisYear,
                        Calendar.DECEMBER,
                        31,
                        23, 59, 59
                ).getTime();
                break;
        }
    }

    private void offset(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(from);
        switch (step) {
            case STEP_DAY:
                calendar.add(Calendar.DAY_OF_MONTH, i);
                break;
            case STEP_MONTH:
                calendar.add(Calendar.MONTH, i);
                break;
            case STEP_YEAR:
                calendar.add(Calendar.YEAR, i);
                break;
        }
        setFromTo(calendar);
    }
}
