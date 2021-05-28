package colval.qc.ca.bird_project.api_not_used.Rest;

import colval.qc.ca.bird_project.model.DTO.UserDTO;
import colval.qc.ca.bird_project.model.entities.User;
import colval.qc.ca.bird_project.service.impl.UserService;
import colval.qc.ca.bird_project.service.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@RestController
//@RequestMapping("/api/User")
public class UserRessource {
    private final UserService userService;
    private final UserMapper userMapper;


    public UserRessource(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll(){
        List<UserDTO> users = this.userService.readAll().stream()
                .map(userMapper::entityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .body(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getPostWithId(@PathVariable int id) {
        Optional<User> user = userService.readOne(id);
        Optional<UserDTO> userDTO = user.stream()
                .map(userMapper::entityToDto)
                .findFirst();
        return userDTO.isPresent() ?  ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .body(userDTO.get()) : new ResponseEntity<>("Customer Id not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("add")
    public ResponseEntity<Void> save(@RequestBody @Valid UserDTO userDTO){
        User user = userMapper.DtoToEntity(userDTO);
        this.userService.create(user);
        return ResponseEntity.created(URI.create(user.toString()))
                .header("Access-Control-Allow-Methods", "POST")
                .build();
    }

    /*@PutMapping("update")
    public ResponseEntity<Void> update(@RequestBody @Valid UserDTO userDTO) {
        User user = userMapper.DtoToEntity(userDTO);
        this.userService.update(user);
        return ResponseEntity.noContent()
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }*/

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        this.userService.delete(id);
        return ResponseEntity.noContent()
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }
}
