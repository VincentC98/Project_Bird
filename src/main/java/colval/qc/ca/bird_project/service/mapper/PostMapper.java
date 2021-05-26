package colval.qc.ca.bird_project.service.mapper;


import colval.qc.ca.bird_project.model.DTO.PostDTO;
import colval.qc.ca.bird_project.model.entities.*;
import colval.qc.ca.bird_project.service.impl.ObservedBirdService;
import colval.qc.ca.bird_project.service.impl.PostService;
import colval.qc.ca.bird_project.service.impl.RegionService;
import colval.qc.ca.bird_project.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PostMapper implements EntityMapper<Post, PostDTO>{
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private ObservedBirdService observedBirdService;
    @Autowired
    private RegionService regionService;

    @Override
    public PostDTO entityToDto(Post post) {
        String userName = post.getUser().getFirstName() + " " + post.getUser().getLastName();
        return new PostDTO(
                post.getPostId(),
                post.getTitle(),
                post.getDescription(),
                post.getPublishDate(),
                post.getPicture(),
                postService.gePostRateAverage(post.getPostId()),
                post.getUser().getId(),
                userName,
                post.getBird().getBirdId(),
                post.getBird().getName(),
                post.getBird().getRegion().getRegionId(),
                post.getBird().getRegion().getName(),
                post.getBird().getRegion().getCountry().getCountryId(),
                post.getBird().getRegion().getCountry().getName()
        );
    }

    @Override
    public Post DtoToEntity(PostDTO postDTO) {
        if(this.postService.readOne(postDTO.getPostId()).isPresent()){
            return this.postService.readOne(postDTO.getPostId()).get();
        } else {
            Region region = this.regionService.readOne(postDTO.getRegionId()).get();
            ObservedBird observedBird = new ObservedBird(
                    postDTO.getBirdId(),
                    postDTO.getBirdName(),
                    region
            );
            Optional<User> user = this.userService.readOne(postDTO.getUserId());
            return new Post(
                postDTO.getPostId(),
                postDTO.getTitle(),
                postDTO.getDescription(),
                postDTO.getPublishDate(),
                postDTO.getPicture(),
                new ArrayList<Rate>(),
                observedBird,
                user.get()
            );
        }

    }
}
