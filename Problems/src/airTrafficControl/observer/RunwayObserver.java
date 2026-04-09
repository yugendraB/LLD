package airTrafficControl.observer;

import airTrafficControl.components.Runway;

public interface RunwayObserver {
    public void onRunwayFreed(Runway runway);
}
