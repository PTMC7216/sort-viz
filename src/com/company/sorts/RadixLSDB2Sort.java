package com.company.sorts;

public class RadixLSDB2Sort extends RadixLSDSort {

    private static RadixLSDB2Sort instance = null;

    private RadixLSDB2Sort() {
        super(2);
    }

    public static RadixLSDB2Sort getInstance() {
        if (instance == null) {
            instance = new RadixLSDB2Sort();
        }
        return instance;
    }
}