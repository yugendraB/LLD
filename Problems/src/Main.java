import airTrafficControl.components.AirCraft;
import airTrafficControl.components.Runway;
import airTrafficControl.mediator.AirControlRoom;
import airTrafficControl.mediator.AirTrafficMediator;

public class Main {
    public static void main(String[] args) {
        AirTrafficMediator controlRoom = new AirControlRoom();

        // Register available runways first so scheduler can start dispatching immediately.
        Runway runway1 = new Runway(controlRoom);
        Runway runway2 = new Runway(controlRoom);
        controlRoom.registerRunway(runway1);
        controlRoom.registerRunway(runway2);

        // Generate mixed traffic to demonstrate landing priority and continuous scheduling.
        AirCraft flight1 = new AirCraft(8.5, false, controlRoom);
        AirCraft flight2 = new AirCraft(2.5, false, controlRoom); // auto-emergency by low fuel
        AirCraft flight3 = new AirCraft(6.2, false, controlRoom);
        AirCraft flight4 = new AirCraft(9.0, false, controlRoom);

        flight1.sendLandingRequest();
        flight2.sendLandingRequest();
        flight3.requestTakeoff();
        flight4.requestTakeoff();
    }
}