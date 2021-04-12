package colval.qc.ca.bird_project.model.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Country")
public class Country {
    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CountryId;
    @Column(name = "name")
    @NonNull
    private String Name;
    @Column(name = "subName")
    @NonNull
    private String SubName;
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Region> regions;

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
