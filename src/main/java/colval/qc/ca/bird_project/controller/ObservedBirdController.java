package colval.qc.ca.bird_project.controller;

import colval.qc.ca.bird_project.service.impl.ObservedBirdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/observedBird")
public class ObservedBirdController {
    private final ObservedBirdService observedBirdService;

    public ObservedBirdController(ObservedBirdService observedBirdService) {
        this.observedBirdService = observedBirdService;
    }

    //page de la liste d'oiseaus observés
    @GetMapping
    public String getAll(Model model, Principal principal){
        model.addAttribute("birds", this.observedBirdService.readAll());

        return "ObservedBird/Birds";
    }
}
