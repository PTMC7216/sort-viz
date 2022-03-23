package com.company.sorts;

import com.company.panels.ControlPanel;
import com.company.panels.VisualizerPanel;

public abstract class Sort {
    public abstract void start(VisualizerPanel vis, ControlPanel con, int sortSpeed);
    public abstract void stop();
}
