package com.codeup.neptunespringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String guess() {
        return "guess";
    }

    @GetMapping("/roll-dice/{n}")
    public String checkGuess(@PathVariable int n, Model model) {
        int magicNumber = (int) Math.floor((Math.random() * 6) + 1);
        boolean check = magicNumber == n;
        model.addAttribute("n", n);
        model.addAttribute("magicNumber", magicNumber);
        model.addAttribute("check", check);
        return "dice-roll-check";
    }
}