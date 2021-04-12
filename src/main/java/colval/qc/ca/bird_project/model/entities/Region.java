package colval.qc.ca.bird_project.model.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Region")
public class Region {
    @Id
    @Column(name = "region_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer RegionId;
    @Column(name = "name")
    @NonNull
    private String Name;
    @Column(name = "subName")
    @NonNull
    private String SubName;
    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    private List<ObservedBird> birds;
    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    private List<Address> addresses;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country country;

    public int getRegionId() {
        return RegionId;
    }

    public void setRegionId(int regionId) {
        RegionId = regionId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<ObservedBird> getBirds() {
        return birds;
    }

    public void setBirds(List<ObservedBird> birds) {
        this.birds = birds;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
