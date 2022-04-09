package com.company.labels;

public class SubArrayUpdatesLabel extends Label {

    private final String name = "Sub updates: ";
    private int updates = 0;

    public SubArrayUpdatesLabel() {
        setText(String.format("%s%s", name, updates));
    }

    public void updateLabel(Integer integer) {
        updates = integer;
        setText(String.format("%s%s", name, updates));
    }

    public void resetLabel() {
        updates = 0;
        setText(String.format("%s%s", name, updates));
    }

}
