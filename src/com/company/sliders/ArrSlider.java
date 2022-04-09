package com.company.sliders;

public class ArrSlider extends Slider {

    public ArrSlider() {
        super("Array size", 4);
        setMinimum(64);
        setMaximum(2048);
        setValue(1024);
    }

}
