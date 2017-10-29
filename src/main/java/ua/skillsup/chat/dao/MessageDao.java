package ua.skillsup.chat.dao;

import ua.skillsup.chat.domain.model.MessageDto;

import java.util.List;

public interface MessageDao {

    MessageDto findById(long id);

    void save(MessageDto message);

    void delete(MessageDto message);

    List<MessageDto> findAll();

    List<MessageDto> findAllByChatRoomId(long id);


    List<MessageDto> findBySubject(String subject);
}
