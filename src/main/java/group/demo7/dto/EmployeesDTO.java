package group.demo7.dto;

import group.demo7.entity.Dependents;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDTO {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;
    private Date hireDate;
    private JobsDTO jobs;
    private long salary;
    private long managerId;
    private DepartmentsDTO departments;
    private List<DependentsDTO> dependents;
}
