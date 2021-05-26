package colval.qc.ca.bird_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String getIndex(){
        return "Index/Index";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login/login";
    }
}
