package ua.skillsup.chat.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.chat.dao.AbstractDao;
import ua.skillsup.chat.dao.UserDao;
import ua.skillsup.chat.dao.entity.User;
import ua.skillsup.chat.domain.model.UserDto;

import java.util.ArrayList;
import java.util.List;

import static ua.skillsup.chat.dao.converters.EntityDtoConverter.convert;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(User.class, sessionFactory);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto findById(long id) {
        return convert(getByKey(id));
    }

    @Override
    public void save(UserDto user) {
        User entity = convert(user);

        persist(entity);
        user.setId(entity.getId());
    }

    @Override
    public void delete(UserDto user) {

    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        List users = listAll();
        ArrayList<UserDto> allUsers = new ArrayList<>(users.size());

        for (Object user : users) {
            allUsers.add(
                    convert((User) user)
            );
        }

        return allUsers;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto findByName(String name) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("name", name));

        return convert((User) criteria.uniqueResult());
    }
}
