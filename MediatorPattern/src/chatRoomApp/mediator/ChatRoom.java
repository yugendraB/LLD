package chatRoomApp.mediator;

import chatRoomApp.components.User;
import chatRoomApp.model.ChatMessage;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatRoom implements ChatMediator {
    private static final Pattern TAG_PATTERN = Pattern.compile("@([a-zA-Z0-9_]+)");
    private final Map<String, ChatGroup> groupsByName;

    public ChatRoom() {
        groupsByName = new HashMap<String, ChatGroup>();
    }

    @Override
    public void createGroup(String groupName) {
        if (groupsByName.containsKey(groupName)) {
            throw new IllegalArgumentException("Group already exists: " + groupName);
        }
        groupsByName.put(groupName, new ChatGroup(groupName));
        System.out.println("Group created: " + groupName);
    }

    @Override
    public void addUserToGroup(String groupName, User user) {
        ChatGroup chatGroup = getGroupOrThrow(groupName);
        chatGroup.addMember(user);
        System.out.println("User: " + user.getName() + " added to group: " + groupName);
    }

    @Override
    public void removeUserFromGroup(String groupName, User user) {
        ChatGroup chatGroup = getGroupOrThrow(groupName);
        chatGroup.removeMember(user);
        System.out.println("User: " + user.getName() + " removed from group: " + groupName);
    }

    @Override
    public void sendMessage(String groupName, String message, User sender, Set<String> mentionedUsers) {
        ChatGroup chatGroup = getGroupOrThrow(groupName);

        if (!chatGroup.hasMember(sender)) {
            throw new IllegalArgumentException("Sender is not a member of group: " + groupName);
        }

        Set<String> normalizedMentions = normalizeMentions(message, mentionedUsers);
        validateMentions(chatGroup, sender, normalizedMentions);

        ChatMessage chatMessage = new ChatMessage(
                groupName,
                sender.getName(),
                message,
                normalizedMentions
        );

        chatGroup.broadcast(chatMessage, sender);
    }

    private ChatGroup getGroupOrThrow(String groupName) {
        ChatGroup chatGroup = groupsByName.get(groupName);
        if (chatGroup == null) {
            throw new IllegalArgumentException("Group does not exist: " + groupName);
        }
        return chatGroup;
    }

    private Set<String> normalizeMentions(String message, Set<String> explicitMentions) {
        Set<String> mentions = new LinkedHashSet<String>();
        if (explicitMentions != null && !explicitMentions.isEmpty()) {
            mentions.addAll(explicitMentions);
            return mentions;
        }

        Matcher matcher = TAG_PATTERN.matcher(message);
        while (matcher.find()) {
            mentions.add(matcher.group(1));
        }
        return mentions;
    }

    private void validateMentions(ChatGroup chatGroup, User sender, Set<String> mentions) {
        for (String mentionedUser : mentions) {
            if (sender.getName().equals(mentionedUser)) {
                throw new IllegalArgumentException("Users cannot tag themselves: " + mentionedUser);
            }
            if (!chatGroup.hasMember(mentionedUser)) {
                throw new IllegalArgumentException(
                        "Mentioned user is not part of group " + chatGroup.getName() + ": " + mentionedUser
                );
            }
        }
    }
}
