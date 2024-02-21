package group.demo7.dto;

import group.demo7.entity.Countries;
import group.demo7.entity.Regions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionsDTO {

    private Long regionsId;

    private String regionName;

    private List<CountriesDTO> countries;
}
