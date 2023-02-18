import java.util.Objects;
public class DoubleCell extends Cell<Double> {
    private Double  value = Double.MIN_VALUE;
    DoubleCell() { }
    DoubleCell(double value) {
        this.value = value;
    }
    DoubleCell(double value, Color color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DoubleCell that = (DoubleCell) o;
        return that.getValue().equals(value) && this.color.equals(that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }

    public String toString() {
        return value+"";
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void reset() {
        this.value = Double.MIN_VALUE;
        this.color = Color.WHITE;
    }
}
