package colval.qc.ca.bird_project.api.Rest;

import colval.qc.ca.bird_project.model.entities.Post;
import colval.qc.ca.bird_project.service.impl.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Post")
public class PostRessource {

    private final PostService postService;

    public PostRessource(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAll(){
        return this.postService.readAll();
    }
}
