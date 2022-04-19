package main.java.sortvisualizer.utils;

import javax.swing.*;

public abstract class PublishWorker<T, V> extends SwingWorker<T, V> {
    @SafeVarargs
    public final void toPublish(V... args) {
        publish(args);
    }
}
