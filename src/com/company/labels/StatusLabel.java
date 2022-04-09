package com.company.labels;

public class StatusLabel extends Label {

    private final String name = "Status: ";
    private String status = "IDLE";

    public StatusLabel() {
        setText(String.format("%s%s", name, status));
    }

    public void setStatus(String status) {
        this.status = status;
        setText(String.format("%s%s", name, this.status));
    }

}
