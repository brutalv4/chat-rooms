package ua.skillsup.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.skillsup.chat.dao.ChatRoomDao;
import ua.skillsup.chat.domain.model.ChatRoomDto;
import ua.skillsup.chat.service.ChatRoomService;

import java.util.List;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {
    private final ChatRoomDao CHATROOM_DAO;

    @Autowired
    public ChatRoomServiceImpl(ChatRoomDao chatRoomDao) {
        this.CHATROOM_DAO = chatRoomDao;
    }


    @Override
    public List<ChatRoomDto> findAll() {
        return CHATROOM_DAO.findAll();
    }

    @Override
    public ChatRoomDto findById(long id) {
        return CHATROOM_DAO.findById(id);
    }
}
