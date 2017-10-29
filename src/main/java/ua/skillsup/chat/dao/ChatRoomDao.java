package ua.skillsup.chat.dao;

import ua.skillsup.chat.domain.model.ChatRoomDto;

import java.util.List;

public interface ChatRoomDao {

    ChatRoomDto findById(long id);

    void save(ChatRoomDto chatRoom);

    void delete(ChatRoomDto chatRoom);

    List<ChatRoomDto> findAll();

    List<ChatRoomDto> findByName(String name);
}
