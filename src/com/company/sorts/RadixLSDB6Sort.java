package com.company.sorts;

public class RadixLSDB6Sort extends RadixLSDSort {

    private static RadixLSDB6Sort instance = null;

    private RadixLSDB6Sort() {
        super(6);
    }

    public static RadixLSDB6Sort getInstance() {
        if (instance == null) {
            instance = new RadixLSDB6Sort();
        }
        return instance;
    }
}