package colval.qc.ca.bird_project.controller;

import colval.qc.ca.bird_project.model.DTO.UserDTO;
import colval.qc.ca.bird_project.model.entities.User;
import colval.qc.ca.bird_project.service.impl.RegionService;
import colval.qc.ca.bird_project.service.impl.UserService;
import colval.qc.ca.bird_project.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/User")
public class UserController {
    private final UserService userService;
    private final RegionService regionService;
    private final UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService, RegionService regionService, UserMapper userMapper) {
        this.userService = userService;
        this.regionService = regionService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public String getUser(Model model, Principal principal){
        model.addAttribute("User", this.userService.getUserByUserName(principal.getName()).get());
        model.addAttribute("userService", this.userService);

        return "User/User";
    }

    @GetMapping("/Create")
    public String createUser(Model model){
        model.addAttribute("User", new UserDTO());
        model.addAttribute("regions", this.regionService.readAll());

        return "login/SignIn";
    }

    @GetMapping("/update")
    public String updateUser(Model model, Principal principal){
        User user = this.userService.getUserByUserName(principal.getName()).get();

        UserDTO userDTO = this.userMapper.entityToDto(user);
        model.addAttribute("User", userDTO);
        return "User/updateUser";
    }

    @PostMapping("/save")
    public String createUser(@ModelAttribute("User") UserDTO userDto){
        System.out.println("user Creation");
        User user = userMapper.DtoToEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (this.userService.readOne(user.getId()).isPresent()){
            this.userService.update(user.getId(),user);
        } else {
            this.userService.create(user);
        }

        return "redirect:/";
    }
}
