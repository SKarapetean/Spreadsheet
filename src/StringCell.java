import java.util.Objects;
public class StringCell extends Cell<String>{
    private String value = "";
    StringCell(){ }
    StringCell(String value) {
        this.value = value;
    }

    StringCell(String value, Color color) {
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
        StringCell that = (StringCell) o;
        return that.value.equals(value) && that.color.equals(color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String toString() {
        return value;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public void reset() {
        value = "";
        color = Color.WHITE;
    }

}