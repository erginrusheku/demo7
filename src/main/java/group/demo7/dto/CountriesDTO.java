package group.demo7.dto;

import group.demo7.entity.Locations;
import group.demo7.entity.Regions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountriesDTO {

    private String countryName;

    private List<LocationsDTO> locations;

    private Regions regions;
}
