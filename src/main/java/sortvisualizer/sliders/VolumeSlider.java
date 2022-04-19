package main.java.sortvisualizer.sliders;

public class VolumeSlider extends Slider {

    public VolumeSlider() {
        super("Volume", 2);
        setMinimum(0);
        setMaximum(10);
        setValue(10);
    }

}
