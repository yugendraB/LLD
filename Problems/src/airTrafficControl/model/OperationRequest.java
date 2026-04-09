package airTrafficControl.model;

import airTrafficControl.idGenerator.IdGenerator;

public class OperationRequest {
    private final String requestId;
    private final String filghtId;
    private final OperationType operationType;
    private final boolean emergencyIndicator;
    private final double fuelLevel;
    private final long timeStamp;



    public OperationRequest(String filghtId, OperationType operationType, boolean emergencyIndicator, double fuelLevel) {
        this.requestId = IdGenerator.generateOperationRequestId();
        this.filghtId = filghtId;
        this.operationType = operationType;
        this.emergencyIndicator = emergencyIndicator;
        this.fuelLevel = fuelLevel;
        this.timeStamp = System.currentTimeMillis();
    }


    public String getRequestId() {
        return requestId;
    }

    public String getFilghtId() {
        return filghtId;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public boolean isEmergencyIndicator() {
        return emergencyIndicator;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}
