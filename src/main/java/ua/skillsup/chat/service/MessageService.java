package ua.skillsup.chat.service;

import ua.skillsup.chat.domain.model.ChatRoomDto;
import ua.skillsup.chat.domain.model.MessageDto;

import java.util.List;

public interface MessageService {

    List<MessageDto> findAll();

    List<MessageDto> findAllByChatRoomId(long id);

    MessageDto findById(long id);

    void save(MessageDto message);
}
