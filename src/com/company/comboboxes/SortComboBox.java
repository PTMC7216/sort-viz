package com.company.comboboxes;

import com.company.sorts.*;

import javax.swing.*;

public class SortComboBox extends JComboBox<String> {

    private String selected;

    public SortComboBox() {
        setUI(new SortComboBoxUI(this));

        String[] items = {"Bubble sort", "Comb sort", "Odd-even sort", "Merge sort", "Quicksort"};
        for (String item : items) {
            addItem(item);
        }

        selected = (String)getSelectedItem();
        addActionListener(e -> selected = (String)getSelectedItem());
    }

    public Sort getSort() {
        switch (selected) {
            case "Bubble sort":
                return BubbleSort.getInstance();
            case "Comb sort":
                return CombSort.getInstance();
            case "Odd-even sort":
                return OddEvenSort.getInstance();
            case "Merge sort":
                return MergeSort.getInstance();
            case "Quicksort":
                return QuickSort.getInstance();
        }
        return null;
    }

}
