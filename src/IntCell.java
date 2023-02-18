import java.util.Objects;
public class IntCell extends Cell<Integer>{
    private Integer value = Integer.MIN_VALUE;
    IntCell(){ }
    IntCell(int value) {
        this.value = value;
    }

    IntCell(int value, Color color) {
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
        IntCell intCell = (IntCell) o;
        return intCell.getValue().equals(value) && this.color.equals(intCell.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
    @Override
    public String toString() {
        return value+"";
    }
    @Override
    public Integer getValue() {
        return value;
    }
    @Override
    public void setValue(Integer value) {
        this.value = value;
    }
    @Override
    public void reset() {
        value = Integer.MIN_VALUE;
        color = Color.WHITE;
    }
}
