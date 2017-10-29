package ua.skillsup.chat.service;

import ua.skillsup.chat.domain.model.ChatRoomDto;

import java.util.List;

public interface ChatRoomService {

    List<ChatRoomDto> findAll();

    ChatRoomDto findById(long id);
}
