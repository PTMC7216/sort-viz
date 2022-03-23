package com.company.sliders;

public class SpeedSlider extends Slider {

    public SpeedSlider() {
        super("Sorting speed", 2);
        setMinimum(1);
        setMaximum(10);
        setValue(1);
    }

}
