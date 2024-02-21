package group.demo7.dto;

import group.demo7.entity.Locations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentsDTO {

    private Long departmentId;
    private String departmentName;
    private Locations locationId;
    private List<EmployeesDTO> employees;
}
