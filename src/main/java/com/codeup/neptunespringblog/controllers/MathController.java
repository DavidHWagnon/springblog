package com.codeup.neptunespringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    // addition URL

    //    @RequestMapping(path = "/add/{num1}/and/{num2}",  method = RequestMethod.GET)
    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String addition(@PathVariable int num1, @PathVariable int num2) {
        return String.valueOf(num1 + num2);
    }

    // subtraction URL

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtraction(@PathVariable int num1, @PathVariable int num2) {
        return String.valueOf(num2 - num1);
    }

    // multiplication URL
    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2) {
        return String.valueOf(num1 * num2);
    }

    // division URL
    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String division(@PathVariable int num1, @PathVariable int num2) {
        return String.valueOf(num1/num2);
    }
}
