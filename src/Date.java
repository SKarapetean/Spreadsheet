import java.util.Objects;
public class Date {
    private Year year;
    private Month month;
    private Day day;
    Date() {
        year = new Year();
        day = new Day();
        reset();
    }

    Date(Day day, Month month, Year year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Date date = (Date) o;
        return date.year.equals(this.year) && date.month.equals(this.month) && date.day.equals(day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    public Year getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year.setYear(year);
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Day getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day.setDay(day);
    }
    public void reset() {
        year.setYear(2023);
        month = Month.Feb;
        day.setDay(29);
    }
}