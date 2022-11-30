package main.java.sortvisualizer.sliders;

public class ArrSlider extends Slider {

    public ArrSlider() {
        super("Array size", 4);
        setMinimum(16);
        setMaximum(4096);
        setValue(2048);
    }

    public int getRestrictedValue(String name) {
        int value = this.getValue();
        if (name.contains("Bitonic")) {
            int i = Integer.highestOneBit(value);
            this.setValue(value > i ? i << 1 : i);
        }
        return value;
    }

}
