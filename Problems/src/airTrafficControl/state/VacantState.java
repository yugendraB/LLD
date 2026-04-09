package airTrafficControl.state;

import airTrafficControl.components.Runway;
import airTrafficControl.model.OperationRequest;
import airTrafficControl.model.RunwayStatus;

public class VacantState implements RunwayState{
    @Override
    public void vacate(Runway runway, OperationRequest request) {
        System.out.println("Runway: " + runway.getRunwayId() + " is already Vacant");
    }

    @Override
    public void occupy(Runway runway, OperationRequest request) {
        System.out.println("Runway: " + runway.getRunwayId() + " is occupied");
        runway.setCurrentStatus(RunwayStatus.OCCUPIED);
        runway.setCurrentState(new OccupiedState());
    }
}
