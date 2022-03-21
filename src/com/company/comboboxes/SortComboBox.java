package com.company.comboboxes;

import com.company.sorts.BubbleSort;
import com.company.sorts.QuickSort;
import com.company.sorts.Sort;

import javax.swing.*;

public class SortComboBox extends JComboBox<String> {

    private String selected;

    public SortComboBox() {
        setUI(new SortComboBoxUI());

        String[] items = {"Quicksort", "Bubble sort"};
        for (String item : items) {
            addItem(item);
        }

        selected = (String)getSelectedItem();
        addActionListener(e -> selected = (String)getSelectedItem());
    }

    public Sort getSort() {
        switch (selected) {
            case "Quicksort":
                return QuickSort.getInstance();
            case "Bubble sort":
                return BubbleSort.getInstance();
        }
        return null;
    }

}
