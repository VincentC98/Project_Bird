package colval.qc.ca.bird_project.model.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ObservedBird")
public class ObservedBird {
    @Id
    @Column(name = "bird_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BirdId;
    @Column(name = "name")
    private String Name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id", referencedColumnName = "region_id")
    private Region region;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post post;

    public int getBirdId() {
        return BirdId;
    }

    public void setBirdId(int birdId) {
        BirdId = birdId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "ObservedBird{" +
                "BirdId=" + BirdId +
                ", Name='" + Name + '\'' +
                ", region=" + region +
                ", post=" + post +
                '}';
    }
}
