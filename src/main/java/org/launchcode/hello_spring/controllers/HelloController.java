package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
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

    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }
    //handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")

    public  String helloWithPathParam(@PathVariable String name){
        return "Hello " + name + "!";

    }
    @GetMapping("form")

    public  String helloWithForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method ='post'>" +
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
