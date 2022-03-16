package com.company.buttons;

import com.company.shuffles.DurstenfeldShuffle;
import com.company.utils.ColorManager;
import com.company.utils.FontManager;

import javax.swing.*;
import java.awt.*;

public class ShuffleButton extends JButton {

    DurstenfeldShuffle shuffle;

    public ShuffleButton(int[] arr) {
        this.setPreferredSize(new Dimension(65, 20));

        this.setBackground(ColorManager.secondary);
        this.setBorder(BorderFactory.createBevelBorder(0));

        this.setFont(FontManager.primary);
        this.setText("Shuffle");
        this.setFocusable(false);

        shuffle = new DurstenfeldShuffle();

        this.addActionListener(e -> {
            System.out.println("Shuffle");
            shuffle.start(arr);
        });
    }

}
