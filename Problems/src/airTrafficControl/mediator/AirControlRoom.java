package airTrafficControl.mediator;

import airTrafficControl.components.Runway;
import airTrafficControl.model.OperationRequest;
import airTrafficControl.util.UtilMethods;

import java.security.InvalidParameterException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class AirControlRoom implements AirTrafficMediator {

    PriorityQueue<OperationRequest> landingQueue = new PriorityQueue<OperationRequest>(new Comparator<OperationRequest>() {
        @Override
        public int compare(OperationRequest a, OperationRequest b) {
            if(a.isEmergencyIndicator() != b.isEmergencyIndicator()){
                return a.isEmergencyIndicator() ? -1:1;
            }
            if(a.getFuelLevel() != b.getFuelLevel()){
                return Double.compare(a.getFuelLevel(), b.getFuelLevel());
            }
            return Long.compare(a.getTimeStamp(), b.getTimeStamp());
        }
    });
    Queue<OperationRequest> takeOffQueue = new LinkedList<OperationRequest>();
    Queue<Runway> vacantRunways = new LinkedList<Runway>();

    @Override
    public synchronized void requestLanding(OperationRequest request){
        if(!UtilMethods.validateLandingRequest(request)){
            throw new InvalidParameterException("Not a valid Landing Request");
        }
        landingQueue.offer(request);
        scheduleIfPossible();
    }
    @Override
    public synchronized void requestTakeoff(OperationRequest request){
        if(!UtilMethods.validateTakeOffRequest(request)){
            throw new InvalidParameterException("Not a valid Takeoff Request");
        }
        takeOffQueue.offer(request);
        scheduleIfPossible();
    }

    @Override
    public synchronized void onRunwayFreed(Runway runway) {
        if(!UtilMethods.isRunwayVacant(runway)){
            throw new InvalidParameterException("Runway is not vacant");
        }
        vacantRunways.offer(runway);
        scheduleIfPossible();
    }

    @Override
    public synchronized void registerRunway(Runway runway) {
        if(!UtilMethods.isRunwayVacant(runway)){
            throw new InvalidParameterException("Only vacant runway can be registered");
        }
        vacantRunways.offer(runway);
        scheduleIfPossible();
    }

    private synchronized void scheduleIfPossible(){
        while(!vacantRunways.isEmpty()){
            OperationRequest nextRequest = getNextRequest();
            if(UtilMethods.isObjectNull(nextRequest)){
                return;
            }
            Runway runway = vacantRunways.poll();
            if(UtilMethods.isObjectNull(runway)){
                return;
            }
            System.out.println(
                    "Scheduling " + nextRequest.getOperationType()
                            + " for flight " + nextRequest.getFilghtId()
                            + " on runway " + runway.getRunwayId()
            );
            new Thread(() -> runway.assignOperationRequest(nextRequest)).start();
        }
    }

    private OperationRequest getNextRequest(){
        if(!landingQueue.isEmpty()){
            return landingQueue.poll();
        }
        if(!takeOffQueue.isEmpty()){
            return takeOffQueue.poll();
        }
        return null;
    }
}
