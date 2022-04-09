package com.company.utils;

public class Publisher {
    private final int category;
    private final int data;

    public Publisher(int category, int data) {
        this.category = category;
        this.data = data;
    }

    public int getCategory() {
        return this.category;
    }

    public int getData() {
        return this.data;
    }
}
