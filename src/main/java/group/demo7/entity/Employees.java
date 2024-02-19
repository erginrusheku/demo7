package group.demo7.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employees {

    @Column(name = "employee_id")
    private long employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "hire_date")
    private Date hireDate;

    @ManyToOne
    @Column(name = "jobs_id")
    private long jobId;

    @Column(name = "salary")
    private long salary;

    @Column(name = "manager_id")
    private long managerId;

    @ManyToOne
    @Column(name = "department_id")
    private long departmentId;
}
