package airTrafficControl.idGenerator;

public class IdGenerator {
    private static int flightCounter = 1;
    private static int runwayCounter = 1;
    private static int operationRequestCounter = 1;

    public static String generateFlightId(){
        return "FL-" + flightCounter++;
    }
    public static String generateRunwayId(){
        return "RN-" + runwayCounter++;
    }
    public static String generateOperationRequestId(){
        return "RQ-" + operationRequestCounter++;
    }
}
