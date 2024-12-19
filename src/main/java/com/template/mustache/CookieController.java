package com.template.mustache;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("/cookie")
public class CookieController {

    @GetMapping
    public String assignNewCookie(HttpServletRequest request, HttpServletResponse response){

        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie);
            }
        }else {

            Cookie cookie = new Cookie("random-number", new Random().nextInt(100) + "");

            cookie.setAttribute("random-number", new Random().nextInt(100) + "");
            cookie.setPath("/cookie");
            cookie.setMaxAge(60);
            response.addCookie(cookie);

        }
        return "index";

    }

}
