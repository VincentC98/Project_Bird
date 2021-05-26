package colval.qc.ca.bird_project.model.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@NamedQueries({
        @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u where u.UserName = :username"),
        @NamedQuery(name = "User.findById", query = "SELECT u FROM User u where u.UserId = :id")
        })
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UserId;
    @Column(name = "FirstName")
    @NonNull
    private String FirstName;
    @Column(name = "LastName")
    @NonNull
    private String LastName;
    @Column(name = "UserName")
    @NonNull
    private String UserName;
    @Column(name = "Password")
    @NonNull
    private String Password;
    @Column(name = "Gender")
    @NonNull
    private String Gender;
    @Column(name = "EmailAddress")
    @NonNull
    private String EmailAddress;
    @Column(name = "BirthDate")
    @NonNull
    private Date BirthDate;
    @Column(name = "Phone")
    @NonNull
    private String Phone;
    @Column(name = "Points")
    private int points;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Post> posts;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getId() {
        return this.UserId;
    }

    public void setId(int id) {
        this.UserId = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Gender='" + Gender + '\'' +
                ", EmailAddress='" + EmailAddress + '\'' +
                ", BirthDate=" + BirthDate +
                ", Phone='" + Phone + '\'' +
                '}';
    }
}
