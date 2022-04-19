package main.java.sortvisualizer.sorts;

public class RadixLSDB4Sort extends RadixLSDSort {

    private static RadixLSDB4Sort instance = null;

    private RadixLSDB4Sort() {
        super(4);
    }

    public static RadixLSDB4Sort getInstance() {
        if (instance == null) {
            instance = new RadixLSDB4Sort();
        }
        return instance;
    }
}