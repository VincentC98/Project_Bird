package colval.qc.ca.bird_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    //page d'accueil
    @GetMapping("/")
    public String getIndex(){
        return "Index/Index";
    }

    //page de login
    @GetMapping("/login")
    public String login(Model model){
        return "login/login";
    }
}
