package ua.skillsup.chat.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.skillsup.chat.service.ChatRoomService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ChatRoomsListController {
    @Autowired
    private ChatRoomService chatRoomService;

    @RequestMapping(value = "/chatrooms", method = RequestMethod.GET)
    public ModelAndView chatrooms(HttpServletRequest request) {
        return new ModelAndView("chatrooms-list",
                        "chatRoomsList",
                        chatRoomService.findAll());
    }

    @RequestMapping(value = "/select-room", method = RequestMethod.GET)
    public void selectRoom(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/enter-chat").forward(req, resp);
    }
}
