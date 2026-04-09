package chatRoomApp;

import chatRoomApp.components.ChatUser;
import chatRoomApp.mediator.ChatMediator;
import chatRoomApp.mediator.ChatRoom;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class ChatApp {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatRoom();

        mediator.createGroup("engineering");
        mediator.createGroup("cricket");

        ChatUser yugendra = new ChatUser("yugendra", mediator);
        ChatUser sanjay = new ChatUser("sanjay", mediator);
        ChatUser thanuja = new ChatUser("thanuja", mediator);
        ChatUser uday = new ChatUser("uday", mediator);

        // A user can be part of multiple groups.
        mediator.addUserToGroup("engineering", yugendra);
        mediator.addUserToGroup("engineering", sanjay);
        mediator.addUserToGroup("engineering", thanuja);

        mediator.addUserToGroup("cricket", sanjay);
        mediator.addUserToGroup("cricket", uday);
        mediator.addUserToGroup("cricket", yugendra);

        yugendra.sendMessage("engineering", "Hi team, let's close the release.");
        sanjay.sendMessage("engineering", "Sure @thanuja, can you review PR-121?");

        uday.sendMessage(
                "cricket",
                "Match at 6 PM. @sanjay are you joining?",
                new LinkedHashSet<String>(Arrays.asList("sanjay"))
        );

        yugendra.sendMessage("cricket", "I'll join too @uday");
    }
}