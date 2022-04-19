package main.java.sortvisualizer.sliders;

public class SpeedSlider extends Slider {

    public SpeedSlider() {
        super("Algorithm speed", 2);
        setMinimum(1);
        setMaximum(10);
        setValue(1);
    }

}
