package com.company.comboboxes;

import javax.swing.*;

public class SortComboBox extends JComboBox<String> {

    public SortComboBox() {

        this.setUI(new SortComboBoxUI());

        String[] items = {"Quicksort", "Bubble sort"};
        for (String item : items) {
            this.addItem(item);
        }

        this.addActionListener(e -> {
            System.out.println(this.getSelectedItem());
        });
    }

}
