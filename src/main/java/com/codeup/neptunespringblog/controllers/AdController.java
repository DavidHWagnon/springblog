package com.codeup.neptunespringblog.controllers;

import com.codeup.neptunespringblog.models.Ad;
import com.codeup.neptunespringblog.models.AdRepository;
import com.codeup.neptunespringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AdController {
    private final AdRepository adDao;

    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }

    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/{n}")
    public String viewOne(@PathVariable long n, Model model) {
        Ad ad = adDao.findById(n);
        model.addAttribute("ad", ad);
        return "ads/show";
    }

    @GetMapping("/ads/first/{title}")
    public String viewOneByTitle(@PathVariable String title, Model model) {
        Ad ad = adDao.findByTitle(title);
        model.addAttribute("ad", ad);
        return "ads/show";
    }
}