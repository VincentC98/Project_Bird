package colval.qc.ca.bird_project.controller;

import colval.qc.ca.bird_project.service.impl.RegionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Region")
public class RegionController {
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    //page de la liste des région avec le nombre d'oiseaux observé dans chaque région
    @GetMapping
    public String getAll(Model model){
        model.addAttribute("regions", this.regionService.readAll());
        model.addAttribute("regionService", this.regionService);

        return "Region/Regions";
    }
}
