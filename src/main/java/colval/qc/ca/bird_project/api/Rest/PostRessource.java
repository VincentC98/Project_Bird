package colval.qc.ca.bird_project.api.Rest;

import colval.qc.ca.bird_project.model.DTO.PostDTO;
import colval.qc.ca.bird_project.model.entities.Post;
import colval.qc.ca.bird_project.service.impl.PostService;
import colval.qc.ca.bird_project.service.mapper.PostMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@RestController
//@CrossOrigin
//@RequestMapping("/api/Post")
public class PostRessource {

    private final PostService postService;
    private final PostMapper postMapper;

    public PostRessource(PostService postService, PostMapper postMapper) {
        this.postService = postService;
        this.postMapper = postMapper;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll(){
        List<PostDTO> posts = this.postService.readAll().stream()
                .map(postMapper::entityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok()
                .body(posts);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getPostWithId(@PathVariable int id) {
        Optional<Post> post = postService.readOne(id);
        Optional<PostDTO> postDTO = post.stream()
                .map(postMapper::entityToDto)
                .findFirst();
        return postDTO.isPresent() ? ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(postDTO.get()) : new ResponseEntity<>("Customer Id not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("add")
    public ResponseEntity<Void> save(@RequestBody @Valid PostDTO postDTO){
        Post post = postMapper.DtoToEntity(postDTO);
        this.postService.create(post);
        return ResponseEntity.created(URI.create(post.toString()))
                .build();
    }

    /*@PutMapping("update")
    public ResponseEntity<Void> update(@RequestBody @Valid PostDTO postDTO) {
        Post post = postMapper.DtoToEntity(postDTO);
        this.postService.update(post);
        return ResponseEntity.noContent()
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }*/

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        this.postService.delete(id);
        return ResponseEntity.noContent()
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }
}
