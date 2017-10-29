package ua.skillsup.chat.domain.model;

import java.util.List;

public class ChatRoomDto extends AbstractHasId {
    private String name;
    private String description;

    private List<UserDto> participants;

    public ChatRoomDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserDto> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UserDto> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "ChatRoomDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}' +
                super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatRoomDto chatRoomDto = (ChatRoomDto) o;

        if (!name.equals(chatRoomDto.name)) return false;
        return participants.equals(chatRoomDto.participants);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + participants.hashCode();
        return result;
    }
}
