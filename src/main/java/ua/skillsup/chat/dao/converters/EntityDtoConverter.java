package ua.skillsup.chat.dao.converters;

import ua.skillsup.chat.dao.entity.ChatRoom;
import ua.skillsup.chat.dao.entity.Message;
import ua.skillsup.chat.dao.entity.User;
import ua.skillsup.chat.domain.model.ChatRoomDto;
import ua.skillsup.chat.domain.model.MessageDto;
import ua.skillsup.chat.domain.model.UserDto;

public class EntityDtoConverter {

    //private default constructor for utility class
    private EntityDtoConverter() {
    }

    public static ChatRoomDto convert(ChatRoom entity) {
        ChatRoomDto dto = new ChatRoomDto();

        if (entity != null) {
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setDescription(entity.getDescription());
        }

        return dto;
    }

    public static ChatRoom convert(ChatRoomDto dto) {
        ChatRoom entity = new ChatRoom();

        if (dto != null) {
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());
        }

        return entity;
    }

    public static UserDto convert(User entity) {
        UserDto dto = new UserDto();

        if (entity != null) {
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPassword(entity.getPassword());
        }

        return dto;
    }

    public static User convert(UserDto dto) {
        User entity = new User();

        if (dto != null) {
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setPassword(dto.getPassword());
        }

        return entity;
    }

    public static MessageDto convert(Message entity) {
        MessageDto dto = new MessageDto();

        if (entity != null) {
            dto.setId(entity.getId());
            dto.setChatRoom(convert(entity.getChatRoom()));
            dto.setUser(convert(entity.getUser()));
            dto.setDateSent(entity.getDateSent());
            dto.setSubject(entity.getSubject());
            dto.setContent(entity.getContent());
        }

        return dto;
    }

    public static Message convert(MessageDto dto) {
        Message entity = new Message();

        if (dto != null) {
            entity.setId(dto.getId());
            entity.setChatRoom(convert(dto.getChatRoom()));
            entity.setUser(convert(dto.getUser()));
            entity.setDateSent(dto.getDateSent());
            entity.setSubject(dto.getSubject());
            entity.setContent(dto.getContent());
        }

        return entity;
    }
}
