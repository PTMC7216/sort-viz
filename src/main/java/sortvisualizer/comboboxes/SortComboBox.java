package main.java.sortvisualizer.comboboxes;

import main.java.sortvisualizer.sorts.*;

import javax.swing.*;

public class SortComboBox extends JComboBox<String> {

    private String selected;

    public SortComboBox() {
        setUI(new SortComboBoxUI(this));

        String[] items = {
                "Bitonic sort",
                "Bogo sort",
                "Bubble sort",
                "Comb sort",
                "Counting sort",
                "Gravity sort",
                "Insertion sort",
                "Merge sort",
                "Odd-even sort",
                "Pairwise sort",
                "Quick sort",
                "Radix LSD B10 sort",
                "Radix LSD B4 sort"
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
            case "Bogo sort":
                return BogoSort.getInstance();
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
            case "Pairwise sort":
                return PairwiseSort.getInstance();
            case "Quick sort":
                return QuickSort.getInstance();
            case "Radix LSD B10 sort":
                return RadixLSDB10Sort.getInstance();
            case "Radix LSD B4 sort":
                return RadixLSDB4Sort.getInstance();
        }
        return null;
    }

}
