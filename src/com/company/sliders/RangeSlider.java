package com.company.sliders;

public class RangeSlider extends Slider {

    public RangeSlider() {
        super("Array size", 4);
        setMinimum(64);
        setMaximum(1024);
        setValue(512);
    }

}
