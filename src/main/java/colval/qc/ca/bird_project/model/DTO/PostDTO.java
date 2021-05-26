package colval.qc.ca.bird_project.model.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private int PostId;
    private String Title;
    private String Description;
    private Date PublishDate;
    private String Picture;
    private double Rate;
    private int UserId;
    private String userName;
    private int BirdId;
    private String BirdName;
    private int RegionId;
    private String BirdRegion;
    private int CountryId;
    private String BirdCountry;

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

    public double getRate() {
        return Rate;
    }

    public void setRate(double rate) {
        Rate = rate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBirdName() {
        return BirdName;
    }

    public void setBirdName(String birdName) {
        BirdName = birdName;
    }

    public String getBirdRegion() {
        return BirdRegion;
    }

    public void setBirdRegion(String birdRegion) {
        BirdRegion = birdRegion;
    }

    public String getBirdCountry() {
        return BirdCountry;
    }

    public void setBirdCountry(String birdCountry) {
        BirdCountry = birdCountry;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getBirdId() {
        return BirdId;
    }

    public void setBirdId(int birdId) {
        BirdId = birdId;
    }

    public int getRegionId() {
        return RegionId;
    }

    public void setRegionId(int regionId) {
        RegionId = regionId;
    }

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }
}
