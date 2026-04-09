package airTrafficControl.mediator;

import airTrafficControl.components.Runway;
import airTrafficControl.model.OperationRequest;

public interface AirTrafficMediator {
    public void requestLanding(OperationRequest request);
    public void requestTakeoff(OperationRequest request);
    public void onRunwayFreed(Runway runway);
    public void registerRunway(Runway runway);
}
