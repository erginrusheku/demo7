package group.demo7.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDTO {

    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;
    private Date hireDate;
    private long jobId;
    private long salary;
    private long managerId;
    private long departmentId;
}
