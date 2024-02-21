package group.demo7.dto;

import group.demo7.entity.Countries;
import group.demo7.entity.Departments;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationsDTO {

    private Long id;

    private String streetAddress;

    private Long postalCode;

    private String city;

    private String stateProvince;

    private Countries countriesId;

    private List<DepartmentsDTO> departments;
}
