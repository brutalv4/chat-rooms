package ua.skillsup.chat.web.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.skillsup.chat.domain.model.User;

@Controller
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        return new ModelAndView("login", "user", new User());
    }

    @RequestMapping(value = "/submit-login", method = RequestMethod.POST)
    public ModelAndView submitLogin(@ModelAttribute("user") User user) {
        return new ModelAndView("main", "user", user);
    }
}
