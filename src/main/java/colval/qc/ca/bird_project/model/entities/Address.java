package colval.qc.ca.bird_project.model.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer AddressId;
    @Column(name = "name")
    private String Name;
    @Column(name = "postal_code")
    private String postal_code;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id", referencedColumnName = "region_id")
    private Region region;

    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int addressId) {
        AddressId = addressId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Address{" +
                "AddressId=" + AddressId +
                ", Name='" + Name + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", user=" + user +
                ", region=" + region +
                '}';
    }
}
