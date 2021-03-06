package se.lexicon.g40_thymeleaf_firstlook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Date;
import java.time.LocalDate;

@Controller
public class TestController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWorld(){
        return "hello";
    }

    @GetMapping("/greeting")
    public String greeting(Model model){
        String message = "Hello Group 40";

        model.addAttribute("message", message);
        model.addAttribute("serverTime", Date.valueOf(LocalDate.now()));
        return "greeting";
    }


}
