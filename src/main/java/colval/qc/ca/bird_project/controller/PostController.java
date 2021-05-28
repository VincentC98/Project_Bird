package colval.qc.ca.bird_project.controller;

import colval.qc.ca.bird_project.model.DTO.PostDTO;
import colval.qc.ca.bird_project.model.entities.*;
import colval.qc.ca.bird_project.service.impl.*;
import colval.qc.ca.bird_project.service.mapper.PostMapper;
import colval.qc.ca.bird_project.util.FileUnploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
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
    private final PostMapper postMapper;

    public PostController(PostService postService, RegionService regionService, UserService userService, RateService rateService, PostMapper postMapper) {
        this.postService = postService;
        this.regionService = regionService;
        this.userService = userService;
        this.rateService = rateService;
        this.postMapper = postMapper;
    }


    //page de la liste des posts créé
    @GetMapping
    public String getAll(Model model, Principal principal){
        model.addAttribute("posts", this.postService.readAll());
        model.addAttribute("postService", this.postService);
        model.addAttribute("user", this.userService.getUserByUserName(principal.getName()));
        model.addAttribute("username", principal.getName());

        return "Post/Posts";
    }

    //page de la création de post
    @GetMapping("/add")
    public ModelAndView addPost(Principal principal) {
        System.out.println(principal.getName());
        ModelAndView modelAndView = new ModelAndView("Post/addPost");
        modelAndView.addObject("regions", this.regionService.readAll());
        modelAndView.addObject("post", new PostDTO());
        modelAndView.addObject("user", principal.getName());

        return modelAndView;
    }

    //traitement de la création de post coté controlleur
    @PostMapping("/save/{username}")
    public String savePost(@Valid PostDTO postDTO, @PathVariable String username, @RequestParam("image") MultipartFile multipartFile) throws IOException {
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

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        post.setPicture(fileName);
        post.setRate(new ArrayList<Rate>());
        post.setUser(user);
        post.setBird(observedBird);
        post.getUser().setPoints(post.getUser().getPoints() + 1);

        postService.create(post);

        //permet de créer un répertoire d'image ou d'ajouter l'image dans ce répertoire
        String unploadDir = "img/";
        FileUnploadUtil.saveFile(unploadDir, fileName, multipartFile);

        return "redirect:/post";
    }

    //traitement de la suppression du post
    @GetMapping("/delete/{id}")
    public String DeletePost(@PathVariable int id){
        Post post = this.postService.readOne(id).get();
        for (Rate rate: post.getRate()){
            this.rateService.delete(rate.getRateId());
        }
        if (this.postService.readOne(id).isPresent()){
            this.postService.delete(id);
        }

        return "redirect:/post";
    }

    //page de modification du post choisi
    @GetMapping("/update/{id}")
    public ModelAndView updatePost(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("Post/updatePost");
        Post post = this.postService.readOne(id).get();
        PostDTO postDTO = this.postMapper.entityToDto(post);
        modelAndView.addObject("post", postDTO);

        return modelAndView;
    }

    //traitement de la modification du post choisi
    @PostMapping(value = "/update/{id}")
    public String savePost(@PathVariable int id, @ModelAttribute("post") PostDTO postDTO){
        System.out.println("update on controller" + postDTO.getTitle());
        Post post = this.postMapper.DtoToEntity(postDTO);
        this.postService.update(id,post);

        return "redirect:/post";
    }

    //page d'ajout d'un rating
    @GetMapping("/addRating/{id}")
    public ModelAndView addRating(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("Post/addRating");
        modelAndView.addObject("post", this.postService.readOne(id).get());
        modelAndView.addObject("rate", new Rate());

        return modelAndView;
    }

    //traitement d'ajout d'un rating avec l'ajout de point à l'utilisateur qui se fait donner le rating
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
