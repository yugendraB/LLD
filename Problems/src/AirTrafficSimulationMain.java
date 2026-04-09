import airTrafficControl.components.AirCraft;
import airTrafficControl.components.Runway;
import airTrafficControl.mediator.AirControlRoom;
import airTrafficControl.mediator.AirTrafficMediator;
import airTrafficControl.model.OperationRequest;
import airTrafficControl.model.OperationType;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class AirTrafficSimulationMain {

    public static void main(String[] args) throws InterruptedException {
        AirTrafficMediator controlRoom = new AirControlRoom();

        // 1) Register more runways.
        int runwayCount = 5;
        List<Runway> runways = new ArrayList<Runway>();
        for (int i = 0; i < runwayCount; i++) {
            Runway runway = new Runway(controlRoom);
            runways.add(runway);
            controlRoom.registerRunway(runway);
        }
        System.out.println("Registered runways: " + runwayCount);

        // 2) Create mixed traffic: normal + explicit emergency + low-fuel emergency.
        List<AirCraft> flights = new ArrayList<AirCraft>();
        flights.add(new AirCraft(8.0, false, controlRoom));
        flights.add(new AirCraft(7.4, false, controlRoom));
        flights.add(new AirCraft(5.3, false, controlRoom));
        flights.add(new AirCraft(2.8, false, controlRoom)); // auto-emergency due to low fuel
        flights.add(new AirCraft(9.1, true, controlRoom));  // explicit emergency
        flights.add(new AirCraft(1.9, false, controlRoom)); // auto-emergency due to low fuel
        flights.add(new AirCraft(6.7, false, controlRoom));
        flights.add(new AirCraft(4.2, false, controlRoom));
        flights.add(new AirCraft(3.3, false, controlRoom));
        flights.add(new AirCraft(7.9, false, controlRoom));
        flights.add(new AirCraft(8.8, false, controlRoom));
        flights.add(new AirCraft(2.2, false, controlRoom)); // auto-emergency due to low fuel

        // 3) Edge case burst: submit from multiple producer threads (landing + takeoff).
        Thread producer1 = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                safeLandingRequest(flights.get(i));
            }
        });
        Thread producer2 = new Thread(() -> {
            for (int i = 6; i < flights.size(); i++) {
                safeTakeoffRequest(flights.get(i));
            }
        });
        Thread producer3 = new Thread(() -> {
            // Mix operations to avoid takeoff starvation in this simulation.
            safeLandingRequest(flights.get(7));
            safeTakeoffRequest(flights.get(0));
            safeLandingRequest(flights.get(10));
            safeTakeoffRequest(flights.get(3));
        });

        producer1.start();
        producer2.start();
        producer3.start();

        producer1.join();
        producer2.join();
        producer3.join();

        // 4) Edge case: intentionally invalid requests and graceful error handling.
        safeInvalidLandingRequest(controlRoom); // requestLanding called with TAKEOFF type
        safeInvalidTakeoffRequest(controlRoom); // requestTakeoff called with LANDING type

        // 5) Keep main alive briefly so async runway operations can print completion.
        Thread.sleep(15000);
        System.out.println("Simulation completed.");
    }

    private static void safeLandingRequest(AirCraft airCraft) {
        try {
            airCraft.sendLandingRequest();
        } catch (Exception e) {
            System.out.println("Landing request failed: " + e.getMessage());
        }
    }

    private static void safeTakeoffRequest(AirCraft airCraft) {
        try {
            airCraft.requestTakeoff();
        } catch (Exception e) {
            System.out.println("Takeoff request failed: " + e.getMessage());
        }
    }

    private static void safeInvalidLandingRequest(AirTrafficMediator controlRoom) {
        try {
            OperationRequest wrongType = new OperationRequest("INVALID-FLIGHT-1", OperationType.TAKEOFF, false, 9.5);
            controlRoom.requestLanding(wrongType);
        } catch (InvalidParameterException e) {
            System.out.println("Handled invalid landing request: " + e.getMessage());
        }
    }

    private static void safeInvalidTakeoffRequest(AirTrafficMediator controlRoom) {
        try {
            OperationRequest wrongType = new OperationRequest("INVALID-FLIGHT-2", OperationType.LANDING, false, 6.0);
            controlRoom.requestTakeoff(wrongType);
        } catch (InvalidParameterException e) {
            System.out.println("Handled invalid takeoff request: " + e.getMessage());
        }
    }
}
