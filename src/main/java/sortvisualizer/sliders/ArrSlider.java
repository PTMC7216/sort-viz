package main.java.sortvisualizer.sliders;

public class ArrSlider extends Slider {

    public ArrSlider() {
        super("Array size", 4);
        setMinimum(16);
        setMaximum(4096);
        setValue(2048);
    }

}
