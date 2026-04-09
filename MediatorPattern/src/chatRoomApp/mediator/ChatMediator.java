package chatRoomApp.mediator;

import chatRoomApp.components.User;

import java.util.Set;

public interface ChatMediator {
    void createGroup(String groupName);

    void addUserToGroup(String groupName, User user);

    void removeUserFromGroup(String groupName, User user);

    void sendMessage(String groupName, String message, User sender, Set<String> mentionedUsers);
}
