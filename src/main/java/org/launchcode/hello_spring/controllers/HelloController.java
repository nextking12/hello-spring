package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller


public class HelloController {
    //Static Requests

    //handles requests at path /hello
   /* @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "Hello, Spring!";
    }*/
    //handles requests at path /goodbye
    @GetMapping("goodbye")

    public String goodbye() {
        return "Goodbye, Spring!";

    }

    //Dynamic requests
    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})

    public String helloWithQueryParam(@RequestParam String name, Model model ) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    //handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")

    public String helloWithPathParam(@PathVariable String name) {
        return "Hello " + name + "!";

    }

    @GetMapping("form")
    public String helloWithForm() {
        return "form";
    }


    // @RequestMapping(value = "hello post", method = {RequestMethod.POST})


    public static String createMessage(String name, String language) {
        String greeting = "";
        if (language.equals("english")) {
            //return "Hello " + name + "!";
            greeting = "Hello";
        } else if (language.equals("spanish")) {
            //return "Hola " + name + "!";
            greeting = "Hola";
        }
        return greeting + " " + name + "!";
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);

    }
}
