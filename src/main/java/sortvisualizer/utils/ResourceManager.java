package main.java.sortvisualizer.utils;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ResourceManager {

    private final URL url;

    public ResourceManager(String filename) {
        url = getClass().getResource(String.format("/main/resources/%s", filename));
    }

    public Image set() {
        if (url != null) {
            return new ImageIcon(url).getImage();
        } else {
            return null;
        }
    }

}
