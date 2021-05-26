package colval.qc.ca.bird_project.model.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Post")
@NamedQueries({
        @NamedQuery(name = "Post.findByCustomerId", query = "SELECT p FROM Post p WHERE p.PostId = :postId")

})
public class Post {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PostId;
    @Column(name = "title")
    private String Title;
    @Column(name = "description")
    private String Description;
    @Column(name = "publish_date")
    private Date PublishDate;
    @Column(name = "picture")
    private String Picture;
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Rate> Rates;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "bird_id", referencedColumnName = "bird_id")
    private ObservedBird bird;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public int getPostId() {
        return PostId;
    }

    public void setPostId(int postId) {
        PostId = postId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getPublishDate() {
        return PublishDate;
    }

    public void setPublishDate(Date publishDate) {
        PublishDate = publishDate;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public List<Rate> getRate() {
        return Rates;
    }

    public void setRate(List<Rate> rate) {
        Rates = rate;
    }

    public ObservedBird getBird() {
        return bird;
    }

    public void setBird(ObservedBird bird) {
        this.bird = bird;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Post{" +
                "PostId=" + PostId +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", PublishDate=" + PublishDate +
                ", Picture='" + Picture + '\'' ;
    }
}
