package airTrafficControl.util;

import airTrafficControl.components.Runway;
import airTrafficControl.model.OperationRequest;
import airTrafficControl.model.OperationType;
import airTrafficControl.model.RunwayStatus;

import java.util.Objects;

public class UtilMethods {
    public static boolean isStringEmptyOrNull(String str){
        return str==null || str.equals("");
    }
    public static boolean isStringNotEmptyNotNull(String str){
        return !(isStringEmptyOrNull(str));
    }
    public static boolean isObjectNull(Object obj){
        return obj==null;
    }
    public static boolean validateLandingRequest(OperationRequest request){
        return OperationType.LANDING.equals(request.getOperationType());
    }
    public static boolean validateTakeOffRequest(OperationRequest request){
        return OperationType.TAKEOFF.equals(request.getOperationType());
    }
    public static boolean isRunwayVacant(Runway runway){
        return RunwayStatus.VACANT.equals(runway.getCurrentStatus());
    }
}
