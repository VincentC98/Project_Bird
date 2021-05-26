package colval.qc.ca.bird_project.model.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
public class RegionDTO {
    private int RegionId;
    private String Name;
    private String SubName;
    private int CountryId;
    private String CountryName;
    private String CountrySubName;

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

    public String getSubName() {
        return SubName;
    }

    public void setSubName(String subName) {
        SubName = subName;
    }

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getCountrySubName() {
        return CountrySubName;
    }

    public void setCountrySubName(String countrySubName) {
        CountrySubName = countrySubName;
    }
}
