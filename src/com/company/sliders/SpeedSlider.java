package com.company.sliders;

public class SpeedSlider extends Slider {

    public SpeedSlider() {
        super();
        setMinimum(1);
        setMaximum(10);
        setValue(1);
        id.setText("Sorting speed");
    }

}
