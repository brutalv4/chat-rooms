package ua.skillsup.chat.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.chat.dao.AbstractDao;
import ua.skillsup.chat.dao.ChatRoomDao;
import ua.skillsup.chat.dao.entity.ChatRoom;
import ua.skillsup.chat.domain.model.ChatRoomDto;

import java.util.ArrayList;
import java.util.List;

import static ua.skillsup.chat.dao.converters.EntityDtoConverter.convert;

@Repository
@Transactional
public class ChatRoomDaoImpl extends AbstractDao<ChatRoom> implements ChatRoomDao {
    @Autowired
    public ChatRoomDaoImpl(SessionFactory sessionFactory) {
        super(ChatRoom.class, sessionFactory);
    }

    @Override
    @Transactional(readOnly = true)
    public ChatRoomDto findById(long id) {
        return convert(getByKey(id));
    }

    @Override
    public void save(ChatRoomDto chatRoom) {
        ChatRoom entity = convert(chatRoom);
        persist(entity);

        chatRoom.setId(entity.getId());
    }

    @Override
    public void delete(ChatRoomDto chatRoom) {
        System.out.println("not yet implemented");
//        ChatRoom entity = convert(chatRoom);
//        remove(entity);
//
//        chatRoom.setId(entity.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ChatRoomDto> findAll() {
        List rooms = listAll();
        ArrayList<ChatRoomDto> allChatRooms = new ArrayList<>(rooms.size());

        for (Object room : rooms) {
            allChatRooms.add(
                    convert((ChatRoom) room)
            );
        }

        return allChatRooms;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ChatRoomDto> findByName(String name) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("name", name));

        List rooms = criteria.list();

        ArrayList<ChatRoomDto> roomsByName = new ArrayList<>(rooms.size());

        for (Object room : rooms) {
            roomsByName.add(
                    convert((ChatRoom) room)
            );
        }

        return roomsByName;
    }
}
