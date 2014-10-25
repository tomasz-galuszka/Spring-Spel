package spel.beans;

/**
 * Created by tomasz on 25.10.14.
 */
public class SimpleCup {

    private String color;
    private int capacity;

    public SimpleCup(String color) {
        this.color = color;
    }

    public SimpleCup(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "SimpleCup{" +
                "color='" + color + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
