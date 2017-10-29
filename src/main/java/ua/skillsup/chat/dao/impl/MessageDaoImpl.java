package ua.skillsup.chat.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.chat.dao.AbstractDao;
import ua.skillsup.chat.dao.MessageDao;
import ua.skillsup.chat.dao.entity.Message;
import ua.skillsup.chat.domain.model.MessageDto;

import java.util.ArrayList;
import java.util.List;

import static ua.skillsup.chat.dao.converters.EntityDtoConverter.convert;

@Repository
@Transactional
public class MessageDaoImpl extends AbstractDao<Message> implements MessageDao {
    @Autowired
    public MessageDaoImpl(SessionFactory sessionFactory) {
        super(Message.class, sessionFactory);
    }

    @Override
    @Transactional(readOnly = true)
    public MessageDto findById(long id) {
        return convert(getByKey(id));
    }

    @Override
    public void save(MessageDto message) {
        Message entity = convert(message);
        persist(entity);

        message.setId(entity.getId());
    }

    @Override
    public void delete(MessageDto message) {
        System.out.println("not yet implemented");
    }

    @Override
    @Transactional(readOnly = true)
    public List<MessageDto> findAll() {
        List messages = listAll();
        ArrayList<MessageDto> allMessages = new ArrayList<>(messages.size());

        for (Object message : messages) {
            allMessages.add(
                    convert((Message) message)
            );
        }

        return allMessages;
    }

    @Override
    public List<MessageDto> findAllByChatRoomId(long id) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("chatRoom.id", id));

        List messages = criteria.list();

        ArrayList<MessageDto> messagesyChatRoomId = new ArrayList<>(messages.size());

        for (Object user : messages) {
            messagesyChatRoomId.add(
                    convert((Message) user)
            );
        }

        return messagesyChatRoomId;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MessageDto> findBySubject(String subject) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("subject", subject));

        List messages = criteria.list();

        ArrayList<MessageDto> messagesByName = new ArrayList<>(messages.size());

        for (Object user : messages) {
            messagesByName.add(
                    convert((Message) user)
            );
        }

        return messagesByName;
    }
}
