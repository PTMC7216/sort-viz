package com.company.sliders;

public class RangeSlider extends Slider {

    public RangeSlider() {
        super("Array size", 4);
        setMinimum(64);
        setMaximum(2048);
        setValue(1024);
    }

}
