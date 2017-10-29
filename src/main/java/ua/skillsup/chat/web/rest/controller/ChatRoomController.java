package ua.skillsup.chat.web.rest.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.skillsup.chat.domain.model.MessageDto;
import ua.skillsup.chat.domain.model.UserDto;
import ua.skillsup.chat.service.ChatRoomService;
import ua.skillsup.chat.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatRoomController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private ChatRoomService chatRoomService;

    @ResponseBody
    @RequestMapping(value = "/get-messages", method = RequestMethod.GET, produces = "application/json")
    public String getMessages(@RequestParam("chatRoomId") String chatRoomId) {
        List<MessageDto> allByChatRoomId = new ArrayList<>();

        if (chatRoomId != null) {
            allByChatRoomId.addAll(messageService.findAllByChatRoomId(Long.valueOf(chatRoomId)));
        }

        return new Gson().toJson(allByChatRoomId);
    }

    @RequestMapping(value = "/enter-chat", method = RequestMethod.GET)
    public String enterChat(HttpServletRequest req, Model model,
                            @RequestParam("chatRoomId") String chatRoomId) {

        model.addAttribute("chatRoomId", chatRoomId);
        model.addAttribute("chatRoomName", chatRoomService.findById(Long.valueOf(chatRoomId)).getName());

        return "chatroom";
    }

    @RequestMapping(value = "/send-message", method = RequestMethod.POST)
    public String sendMessage(HttpServletRequest req, HttpServletResponse resp,
                            @RequestParam("chatRoomId") String chatRoomId,
                            @RequestParam("content") String content,
                            @SessionAttribute("user") UserDto user) throws IOException, ServletException {

        MessageDto newMessage = new MessageDto();

        newMessage.setChatRoom(
                chatRoomService.findById(Long.valueOf(chatRoomId))
        );
        newMessage.setUser(user);
        newMessage.setSubject(content); //20171029 - subj == content
        newMessage.setContent(content);
        newMessage.setDateSent(LocalDateTime.now());

        messageService.save(newMessage);

        return "chatroom";
    }
}
