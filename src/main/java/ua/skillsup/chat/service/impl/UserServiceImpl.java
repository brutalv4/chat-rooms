package ua.skillsup.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.skillsup.chat.dao.UserDao;
import ua.skillsup.chat.domain.model.UserDto;
import ua.skillsup.chat.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao DAO;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        DAO = dao;
    }

    @Override
    public UserDto findById(long id) {
        return DAO.findById(id);
    }

    @Override
    public UserDto findByName(String name) {
        return DAO.findByName(name);
    }
}
