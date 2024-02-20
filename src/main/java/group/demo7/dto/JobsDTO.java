package group.demo7.dto;

import group.demo7.entity.Employees;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class JobsDTO {

    private String jobTitle;

    private long minSalary;

    private long maxSalary;

    private List<EmployeesDTO> employees;

}
