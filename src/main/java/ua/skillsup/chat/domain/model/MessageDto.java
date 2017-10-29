package ua.skillsup.chat.domain.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class MessageDto extends AbstractHasId {
    private ChatRoomDto chatRoom;
    private UserDto user;
    private LocalDateTime dateSent;
    private String subject;
    private String content;

    public MessageDto() {
    }

    public ChatRoomDto getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoomDto chatRoom) {
        this.chatRoom = chatRoom;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public LocalDateTime getDateSent() {
        return dateSent;
    }

    public void setDateSent(LocalDateTime dateSent) {
        this.dateSent = dateSent;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageDto that = (MessageDto) o;

        if (!user.equals(that.user)) return false;
        if (!dateSent.equals(that.dateSent)) return false;
        return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + dateSent.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "user=" + user +
                ", dateSent=" + dateSent +
                ", content='" + content + '\'' +
                '}';
    }
}
