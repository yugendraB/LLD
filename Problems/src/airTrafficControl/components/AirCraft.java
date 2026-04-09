package airTrafficControl.components;

import airTrafficControl.idGenerator.IdGenerator;
import airTrafficControl.mediator.AirTrafficMediator;
import airTrafficControl.model.OperationRequest;
import airTrafficControl.model.OperationType;
import airTrafficControl.util.UtilMethods;

import java.rmi.server.UID;

public class AirCraft {
    private String aircraftId;
    private double fuelLevel;
    private boolean emergencyIndicator;
    private AirTrafficMediator controlRoom;

    public AirCraft(double fuelLevel, boolean emergencyIndicator, AirTrafficMediator controlRoom) {
        this.aircraftId = IdGenerator.generateFlightId();
        this.fuelLevel = fuelLevel;
        this.emergencyIndicator = emergencyIndicator;
        this.controlRoom = controlRoom;
        if(fuelLevel<3){
            this.emergencyIndicator=true;
        }
    }

    public void sendLandingRequest(){
        OperationRequest request = prepareOperationRequest(OperationType.LANDING);
        controlRoom.requestLanding(request);
    }
    public void requestTakeoff(){
        OperationRequest request = prepareOperationRequest(OperationType.TAKEOFF);
        controlRoom.requestTakeoff(request);
    }

    public OperationRequest prepareOperationRequest(OperationType type){
        if(!UtilMethods.isObjectNull(type) && type.equals(OperationType.LANDING)){
            return new OperationRequest(aircraftId, OperationType.LANDING, emergencyIndicator, fuelLevel);
        }
        else if(!UtilMethods.isObjectNull(type) && type.equals(OperationType.TAKEOFF)){
            return new OperationRequest(aircraftId, OperationType.TAKEOFF, emergencyIndicator, fuelLevel);
        }
        return null;
    }

    public String getAircraftId() {
        return aircraftId;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public boolean isEmergencyIndicator() {
        return emergencyIndicator;
    }
}
