package ua.skillsup.chat;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.skillsup.chat.dao.ChatRoomDao;
import ua.skillsup.chat.dao.UserDao;
import ua.skillsup.chat.dao.entity.User;
import ua.skillsup.chat.domain.model.ChatRoomDto;
import ua.skillsup.chat.domain.model.UserDto;

public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("context-config/core.xml");

        UserDao dao = context.getBean(UserDao.class);

        dao.save(new UserDto("admin", "admin", true));
        dao.save(new UserDto("userDto1", "userDto1", false));

        dao.findAll().forEach(System.out::println);
    }
}
