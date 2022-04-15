package com.company.comboboxes;

import com.company.sorts.*;

import javax.swing.*;

public class SortComboBox extends JComboBox<String> {

    private String selected;

    public SortComboBox() {
        setUI(new SortComboBoxUI(this));

        String[] items = {
                "Bitonic sort",
                "Bubble sort",
                "Comb sort",
                "Counting sort",
                "Gravity sort",
                "Insertion sort",
                "Merge sort",
                "Odd-even sort",
                "Quicksort",
                "Radix LSD B10 sort",
                "Radix LSD B6 sort",
                "Radix LSD B2 sort"
        };

        for (String item : items) {
            addItem(item);
        }

        selected = (String)getSelectedItem();
        addActionListener(e -> selected = (String)getSelectedItem());
    }

    public Sort getSort() {
        switch (selected) {
            case "Bitonic sort":
                return BitonicSort.getInstance();
            case "Bubble sort":
                return BubbleSort.getInstance();
            case "Comb sort":
                return CombSort.getInstance();
            case "Counting sort":
                return CountingSort.getInstance();
            case "Gravity sort":
                return GravitySort.getInstance();
            case "Insertion sort":
                return InsertionSort.getInstance();
            case "Merge sort":
                return MergeSort.getInstance();
            case "Odd-even sort":
                return OddEvenSort.getInstance();
            case "Quicksort":
                return QuickSort.getInstance();
            case "Radix LSD B10 sort":
                return RadixLSDB10Sort.getInstance();
            case "Radix LSD B6 sort":
                return RadixLSDB6Sort.getInstance();
            case "Radix LSD B2 sort":
                return RadixLSDB2Sort.getInstance();
        }
        return null;
    }

}
