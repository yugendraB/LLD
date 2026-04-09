package chatRoomApp.components;

import chatRoomApp.model.ChatMessage;
import chatRoomApp.mediator.ChatMediator;

import java.util.Set;

public abstract class User {
    protected String name;
    protected ChatMediator mediator;

    public User(String name, ChatMediator mediator){
        this.name = name;
        this.mediator = mediator;
    }

    public abstract void sendMessage(String groupName, String message);

    public abstract void sendMessage(String groupName, String message, Set<String> mentionedUsers);

    public abstract void receiveMessage(ChatMessage chatMessage);

    public String getName(){
        return this.name;
    }
}
