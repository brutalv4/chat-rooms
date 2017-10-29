package ua.skillsup.chat.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ua.skillsup.chat.domain.model.UserDto;
import ua.skillsup.chat.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@SessionAttributes(names = {"user"})
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest req, HttpServletResponse resp) {
        UserDto defaultUser = new UserDto();
        defaultUser.setName("user1");
        return new ModelAndView("login", "currentUser", defaultUser);
    }

    @RequestMapping(value = "submit-login", method = RequestMethod.POST)
    public ModelAndView submitLogin(HttpServletRequest request, HttpServletResponse response,
                                    @ModelAttribute("currentUser") UserDto currentUser) throws IOException {

        String nextViewNAme = "login";
        UserDto dbUser = userService.findByName(currentUser.getName());

        ModelAndView modelAndView = new ModelAndView();

        if (dbUser.getPassword().equals(currentUser.getPassword())) {
            // users are equals
            nextViewNAme = "chatrooms-list";
            modelAndView.addObject("user", dbUser);
        }

        modelAndView.setViewName(nextViewNAme);

        response.sendRedirect(request.getContextPath() + "/chatrooms");

        return modelAndView;
    }
}
