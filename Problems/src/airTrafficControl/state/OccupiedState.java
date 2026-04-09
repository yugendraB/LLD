package airTrafficControl.state;

import airTrafficControl.components.Runway;
import airTrafficControl.model.OperationRequest;
import airTrafficControl.model.RunwayStatus;

public class OccupiedState implements RunwayState{
    @Override
    public void vacate(Runway runway, OperationRequest request) {
        System.out.println("Runway: " + runway.getRunwayId() + " is vacant now");
        runway.setCurrentStatus(RunwayStatus.VACANT);
        runway.setCurrentState(new VacantState());
        runway.nofifyRunwayFreed();
    }

    @Override
    public void occupy(Runway runway, OperationRequest request) {
        System.out.println("Runway is Already Occupied");
    }
}
