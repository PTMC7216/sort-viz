package com.company.sliders;

public class RangeSlider extends Slider {

    public RangeSlider() {
        super();
        setMinimum(64);
        setMaximum(1024);
        setValue(512);
        id.setText("Array size");
    }

}
