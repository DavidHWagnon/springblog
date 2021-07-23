package com.codeup.neptunespringblog.controllers;

import com.codeup.neptunespringblog.models.AdRepository;
import com.codeup.neptunespringblog.models.Post;
import com.codeup.neptunespringblog.models.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private List<Post> posts = new ArrayList<>();

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String viewPosts(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/edit/{id}")
    public String editForm(Model model,@PathVariable long id){
        model.addAttribute("post", postDao.findById(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, @RequestParam String title, @RequestParam String body, Model model){
        model.addAttribute("post", postDao.findById(id));
        return "posts/edit";
    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findById(id));
        return "posts/show";
    }


    @PostMapping("/posts/save/edit/{id}")
    public String editOne(Model model,@PathVariable long id, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        Post post = postDao.findById(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts/" + post.getId();
    }
    @PostMapping("/posts/delete/{id}")
    public String deleteOne(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    // When you visit the URL you will see the form to create a post.
    @GetMapping("/posts/create")
    @ResponseBody
    public String createForm() {
        return "View form to create a post.";
    }

    // When you submit the form on the /posts/create page,
    // the information will be posted to the same URL
//    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Creates new post.";
    }
}