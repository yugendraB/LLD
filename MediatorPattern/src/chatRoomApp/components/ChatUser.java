package chatRoomApp.components;

import chatRoomApp.model.ChatMessage;
import chatRoomApp.mediator.ChatMediator;

import java.util.Collections;
import java.util.Set;

public class ChatUser extends User {
    public ChatUser(String name, ChatMediator mediator){
        super(name, mediator);
    }

    @Override
    public void sendMessage(String groupName, String message) {
        sendMessage(groupName, message, Collections.<String>emptySet());
    }

    @Override
    public void sendMessage(String groupName, String message, Set<String> mentionedUsers) {
        System.out.println("[" + groupName + "] " + this.getName() + " -> " + message);
        mediator.sendMessage(groupName, message, this, mentionedUsers);
    }

    @Override
    public void receiveMessage(ChatMessage chatMessage) {
        boolean isTagged = chatMessage.getMentionedUsers().contains(this.getName());
        String taggedPrefix = isTagged ? "[TAGGED] " : "";
        System.out.println(
                taggedPrefix + "[" + chatMessage.getGroupName() + "] "
                        + this.getName() + " received from "
                        + chatMessage.getSenderName() + " -> "
                        + chatMessage.getContent()
        );
    }
}
