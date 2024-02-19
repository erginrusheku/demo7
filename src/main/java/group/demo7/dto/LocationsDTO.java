package group.demo7.dto;

import group.demo7.entity.Countries;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationsDTO {

    private String streetAddress;

    private Long postalCode;

    private String city;

    private String stateProvince;
    // To be FK
    private Countries countryId;
}
