abstract public class Cell<T> {
    protected T value;
    protected Color color = Color.WHITE;
    Cell () {
    }
    public abstract boolean equals(Object obj);
    public abstract String toString();

    public abstract  void reset () ;
    public void setColor (Color color){
        this.color = color;
    }

    public Color getColor () {
        return color;
    }

    public abstract T getValue();

    public abstract void setValue(T value);
}