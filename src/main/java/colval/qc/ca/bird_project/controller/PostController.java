package colval.qc.ca.bird_project.controller;

import colval.qc.ca.bird_project.model.DTO.PostDTO;
import colval.qc.ca.bird_project.model.entities.*;
import colval.qc.ca.bird_project.service.impl.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    private final RegionService regionService;
    private final UserService userService;
    private final RateService rateService;

    public PostController(PostService postService, RegionService regionService, UserService userService, RateService rateService) {
        this.postService = postService;
        this.regionService = regionService;
        this.userService = userService;
        this.rateService = rateService;
    }

    @GetMapping
    public String getAll(Model model, Principal principal){
        //System.out.println(principal.getName());

        /*for (Post post : this.postService.readAll()){
            System.out.println(post);
            System.out.println(post.getUser());
        }
        System.out.println(this.userService.getUserByUserName(principal.getName()));*/
        model.addAttribute("posts", this.postService.readAll());
        model.addAttribute("postService", this.postService);
        model.addAttribute("user", this.userService.getUserByUserName(principal.getName()));
        model.addAttribute("username", principal.getName());

        return "Post/Posts";
    }

    @GetMapping("/add")
    public ModelAndView addPost(Principal principal) {
        System.out.println(principal.getName());
        ModelAndView modelAndView = new ModelAndView("Post/addPost");
        modelAndView.addObject("regions", this.regionService.readAll());
        modelAndView.addObject("post", new PostDTO());
        modelAndView.addObject("user", principal.getName());

        return modelAndView;
    }

    @PostMapping("/save/{username}")
    public String savePost(@Valid PostDTO postDTO, @PathVariable String username){
        System.out.println(username);
        Post post = new Post();
        Region region = regionService.readOne(postDTO.getRegionId()).get();
        ObservedBird observedBird = new ObservedBird();
        observedBird.setName(postDTO.getBirdName());
        observedBird.setRegion(region);
        User user = userService.getUserByUserName(username).get();
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setPublishDate(new Date());
        post.setPicture(postDTO.getPicture());
        post.setRate(new ArrayList<Rate>());
        post.setUser(user);
        post.setBird(observedBird);
        post.getUser().setPoints(post.getUser().getPoints() + 1);

        postService.create(post);

        return "redirect:/post";
    }

    @GetMapping("/delete/{id}")
    public String DeletePost(@PathVariable int id){
        this.postService.delete(id);
        return "redirect:/post";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updatePost(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("Post/updatePost");
        Post post = this.postService.readOne(id).get();
        modelAndView.addObject("post", post);

        return modelAndView;
    }

    @PostMapping(value = "/update/{id}")
    public String savePost(@PathVariable int id, @ModelAttribute("post") Post post){
        System.out.println("update on controller" + post.getTitle());
        this.postService.update(id,post);

        return "redirect:/post";
    }

    @GetMapping("/addRating/{id}")
    public ModelAndView addRating(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("Post/addRating");
        modelAndView.addObject("post", this.postService.readOne(id).get());
        modelAndView.addObject("rate", new Rate());

        return modelAndView;
    }

    @PostMapping("/addRating/{id}")
    public String addRating(@PathVariable int id, @ModelAttribute("rate") Rate rate){
        Post post = this.postService.readOne(id).get();
        int points = this.rateService.addPoint(rate.getRate());

        rate.setPost(post);
        rate.getPost().getUser().setPoints(
                rate.getPost().getUser().getPoints() + points);

        this.rateService.create(rate);

        return "redirect:/post";
    }
}
