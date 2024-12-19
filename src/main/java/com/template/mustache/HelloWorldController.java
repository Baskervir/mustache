package com.template.mustache;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *  localhost:8080/helloword?name=jungmin
 *
 * **/
//@Controller
public class HelloWorldController {

//    @GetMapping("/")
    public String handleHelloWorld(){

        return "index";

    }

//    @PostMapping(value = "/hello" )
    public String handlePostMethod(@RequestParam Map<String, String> pairs, RedirectAttributes redirectAttrs){

        System.out.println("body : "+pairs);
        List<String> list = pairs.entrySet().stream()
                .map(t -> t.getKey() + " : " + t.getValue())
                .toList();
        System.out.println(list);
        redirectAttrs.addFlashAttribute("items", list);

        return "redirect:/result";
    }

//    @GetMapping(value = "/result" )
    public String handlePostMethod(){
        System.out.println("invoked!!");

        return "put";
    }

}
