package com.codeup.neptunespringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "<h1>Hello from Spring!</h1>";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }


    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }


    @GetMapping("/number/{num}")
    @ResponseBody
    public String displayNumber(@PathVariable int num) {
        // must use the value of method to return the value of the integer as a string object.
        return String.valueOf(num);
    }

    @RequestMapping(path = "/hello/in/{color}", method = RequestMethod.GET)
    @ResponseBody
    public String helloInColor(@PathVariable String color) {
        return "<h1 style=\"color: " + color + "\">Hello in " + color + "!</h1>";
    }
}
