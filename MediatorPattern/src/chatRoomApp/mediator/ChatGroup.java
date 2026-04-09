package chatRoomApp.mediator;

import chatRoomApp.components.User;
import chatRoomApp.model.ChatMessage;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

class ChatGroup {
    private final String name;
    private final Map<String, User> membersByName;

    ChatGroup(String name) {
        this.name = name;
        this.membersByName = new LinkedHashMap<String, User>();
    }

    String getName() {
        return name;
    }

    void addMember(User user) {
        membersByName.put(user.getName(), user);
    }

    void removeMember(User user) {
        membersByName.remove(user.getName());
    }

    boolean hasMember(User user) {
        return membersByName.containsKey(user.getName());
    }

    boolean hasMember(String userName) {
        return membersByName.containsKey(userName);
    }

    Collection<User> getMembers() {
        return Collections.unmodifiableCollection(membersByName.values());
    }

    void broadcast(ChatMessage chatMessage, User sender) {
        for (User member : membersByName.values()) {
            if (!member.getName().equals(sender.getName())) {
                member.receiveMessage(chatMessage);
            }
        }
    }
}
