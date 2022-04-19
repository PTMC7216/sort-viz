package main.java.sortvisualizer.labels;

public class ArrayUpdatesLabel extends Label {

    private final String name = "Main updates: ";
    private int updates = 0;

    public ArrayUpdatesLabel() {
        setText(String.format("%s%s", name, updates));
    }

    public void updateLabel(Integer integer) {
        updates = integer;
        setText(String.format("%s%s", name, updates));
    }

    public void resetLabel() {
        updates = 0;
        setText(String.format("%s%s", name, updates));
    }

}
