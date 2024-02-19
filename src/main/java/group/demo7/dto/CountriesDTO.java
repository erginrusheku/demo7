package group.demo7.dto;

import group.demo7.entity.Regions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountriesDTO {

    private String countryName;

    //FK
    private Regions regionId;
}
