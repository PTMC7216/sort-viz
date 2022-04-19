package main.java.sortvisualizer.sorts;

public class RadixLSDB10Sort extends RadixLSDSort {

    private static RadixLSDB10Sort instance = null;

    private RadixLSDB10Sort() {
        super(10);
    }

    public static RadixLSDB10Sort getInstance() {
        if (instance == null) {
            instance = new RadixLSDB10Sort();
        }
        return instance;
    }
}