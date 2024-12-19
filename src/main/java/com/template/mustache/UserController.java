package com.template.mustache;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
public class UserController {

    /**
     *  사용자가 localhost:8080/index.html 요청을 보냈을 때, 이 요청을 처리할 수 있는 핸들러를 등록한다
     *
     * localhost:8080/index.html
     * localhost:8080/
     *
     * **/
    @GetMapping("/")
    public String handleGetIndexFile(){
        System.out.println("invkoed index file");
        return "index";
    }

    @GetMapping("/order")
    public String handleGetOrderPage(){
        System.out.println("invkoed order file");
        return "order";
    }


    /**
     * PRG Pattern => Post -> Redirection -> Get
     *
     * **/
    @PostMapping("/hello")
    public RedirectView handleHelloPost(@RequestParam Map<String, String> param){
        System.out.println(param);
        return new RedirectView("/order");
    }
}
