package airTrafficControl.state;

import airTrafficControl.components.Runway;
import airTrafficControl.model.OperationRequest;

public interface RunwayState {
    public void vacate(Runway runway, OperationRequest request);
    public void occupy(Runway runway, OperationRequest request);
}
