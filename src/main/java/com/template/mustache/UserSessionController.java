package com.template.mustache;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/session")
public class UserSessionController {

    @GetMapping
    public String storeUserInformation(Model model, @RequestParam String userName, HttpSession session){
        session.setAttribute("userName", userName);
        model.addAttribute("userName", userName);

        return "session/index";
    }

    @GetMapping("/hello")
    public String keeyUserInfo(Model model, HttpSession session){
        model.addAttribute("userName", session.getAttribute("userName"));
        return "session/hello";
    }

}
