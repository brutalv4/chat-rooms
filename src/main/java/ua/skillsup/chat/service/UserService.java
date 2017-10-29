package ua.skillsup.chat.service;

import ua.skillsup.chat.domain.model.UserDto;

public interface UserService {

    UserDto findById(long id);

    UserDto findByName(String name);
}
