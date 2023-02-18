import java.util.Objects;
public class Day {
    private int day;
    Day() {}
    Day(int day) {
        if (day <= 0 || day > 31) {
            throw new IllegalStateException(" the day of the month can't be below 0 or above 31");
        }
        this.day = day;
    }

    public void setDay(int day) {
        if (day <= 0 || day > 31) {
            throw new IllegalStateException(" the day of the month can't be below 0 or above 31");
        }
        this.day = day;
    }

    public int getDay() {
        return day;
    }
    @Override
    public String toString() {
        return day + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Day day1 = (Day) o;
        return day == day1.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day);
    }
}