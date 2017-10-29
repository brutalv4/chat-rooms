package ua.skillsup.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.skillsup.chat.dao.MessageDao;
import ua.skillsup.chat.domain.model.MessageDto;
import ua.skillsup.chat.service.MessageService;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageDao DAO;

    @Autowired
    public MessageServiceImpl(MessageDao messageDao) {
        this.DAO = messageDao;
    }

    @Override
    public List<MessageDto> findAll() {
        return DAO.findAll();
    }

    @Override
    public List<MessageDto> findAllByChatRoomId(long id) {
        return DAO.findAllByChatRoomId(id);
    }

    @Override
    public MessageDto findById(long id) {
        return DAO.findById(id);
    }

    @Override
    public void save(MessageDto message) {
        DAO.save(message);
    }
}
