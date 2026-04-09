package chatRoomApp.model;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class ChatMessage {
    private final String groupName;
    private final String senderName;
    private final String content;
    private final Set<String> mentionedUsers;
    private final LocalDateTime sentAt;

    public ChatMessage(String groupName, String senderName, String content, Set<String> mentionedUsers) {
        this.groupName = groupName;
        this.senderName = senderName;
        this.content = content;
        this.mentionedUsers = Collections.unmodifiableSet(new LinkedHashSet<String>(mentionedUsers));
        this.sentAt = LocalDateTime.now();
    }

    public String getGroupName() {
        return groupName;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getContent() {
        return content;
    }

    public Set<String> getMentionedUsers() {
        return mentionedUsers;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }
}
