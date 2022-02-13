package io.muic.ooc.fab.observer;

import io.muic.ooc.fab.Field;
import io.muic.ooc.fab.view.SimulatorView;

public class SimulationObserver extends Observer{

    SimulatorView simulatorView;

    public SimulationObserver(SimulatorView simulatorView) {
        this.simulatorView = simulatorView;
    }

    @Override
    public void update(int step, Field field) {
        simulatorView.showStatus(step, field);
    }


}
