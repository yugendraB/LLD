package airTrafficControl.components;

import airTrafficControl.idGenerator.IdGenerator;
import airTrafficControl.mediator.AirTrafficMediator;
import airTrafficControl.model.OperationDurationConfig;
import airTrafficControl.model.OperationRequest;
import airTrafficControl.model.OperationType;
import airTrafficControl.model.RunwayStatus;
import airTrafficControl.observer.RunwaySubject;
import airTrafficControl.state.VacantState;
import airTrafficControl.state.RunwayState;

public class Runway implements RunwaySubject {
    private String runwayId;
    private RunwayStatus currentStatus;
    private RunwayState currentState;
    private AirTrafficMediator controlRoom;

    public Runway(AirTrafficMediator controlRoom){
        this.runwayId = IdGenerator.generateRunwayId();
        this.currentStatus = RunwayStatus.VACANT;
        this.currentState = new VacantState();
        this.controlRoom = controlRoom;
    }
    public void assignOperationRequest(OperationRequest request){
        currentState.occupy(this, request);
        int duration=0;
        if(OperationType.LANDING.equals(request.getOperationType())){
            duration = OperationDurationConfig.landing;
        }
        else if(OperationType.TAKEOFF.equals(request.getOperationType())){
            duration = OperationDurationConfig.takeoff;
        }
        try{
            Thread.sleep((long)duration*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            vacateRunway(request);
        }
    }
    public void vacateRunway(OperationRequest request){
        currentState.vacate(this,request);
    }
    @Override
    public void nofifyRunwayFreed() {
        if(RunwayStatus.VACANT.equals(getCurrentStatus())){
            controlRoom.onRunwayFreed(this);
        }
    }

    public String getRunwayId() {
        return runwayId;
    }

    public RunwayStatus getCurrentStatus() {
        return currentStatus;
    }

    public RunwayState getCurrentState() {
        return currentState;
    }

    public void setCurrentStatus(RunwayStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public void setCurrentState(RunwayState currentState) {
        this.currentState = currentState;
    }
}
