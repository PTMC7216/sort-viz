package com.company.sorts;

import com.company.panels.VisualizerPanel;

public abstract class Sort {
    public abstract void start(VisualizerPanel vis, int sortSpeed);
    public abstract void stop();
}
