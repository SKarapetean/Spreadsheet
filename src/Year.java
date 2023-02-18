import java.util.Objects;
public class Year {
    private String year;
    Year() {}
    Year(int year){
        if (year < 0 ) {
            this.year = (-1 * year) + " BC";
        } else {
            this.year = year + "";
        }
    }

    public void setYear(int year) {
        if (year < 0 ) {
            this.year = year + " BC";
        } else {
            this.year = year + "";
        }
    }

    public int getYear() {
        if (year.charAt(year.length() - 1) == 'C') {
            return Integer.parseInt(year.substring(0, year.length() - 2)) * -1;
        } else {
            return Integer.parseInt(year);
        }
    }
    @Override
    public String toString() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Year year1 = (Year) o;
        return Objects.equals(year, year1.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year);
    }
}
