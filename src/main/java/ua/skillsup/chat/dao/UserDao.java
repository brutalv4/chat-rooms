package ua.skillsup.chat.dao;

import ua.skillsup.chat.domain.model.UserDto;

import java.util.List;

public interface UserDao {

    UserDto findById(long id);

    void save(UserDto user);

    void delete(UserDto user);

    List<UserDto> findAll();

    UserDto findByName(String name);
}
