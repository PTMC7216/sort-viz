package main.java.sortvisualizer.labels;

import main.java.sortvisualizer.utils.ResourceManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class GitHubLabel extends JLabel {

    public GitHubLabel() {
        ResourceManager resource = new ResourceManager("github_icon.png");
        setIcon(new ImageIcon(resource.set().getScaledInstance(18, 18, Image.SCALE_SMOOTH)));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/PTMC7216/sort-viz"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

}
