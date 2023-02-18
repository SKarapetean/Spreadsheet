import java.util.Objects;
public class DateCell extends Cell <Date>{
    private Date value = new Date();
    DateCell() {}
    DateCell (Date value) {
        this.value = value;
    }

    DateCell (Date value, Color color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DateCell dateCell = (DateCell) o;
        return dateCell.value.equals(this.value) && color.equals(dateCell.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


    public Date getValue() {
        return value;
    }

    @Override
    public void setValue(Date value) {
        this.value = value;
    }

    public void reset() {
        value.setYear(2023);
        value.setMonth(Month.Feb);
        value.setDay(29);
        color = Color.WHITE;
    }
}