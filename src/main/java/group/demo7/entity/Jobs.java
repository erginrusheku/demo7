package group.demo7.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "JOBS")
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_id")
    private long jobId;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "min_salary")
    private long minSalary;

    @Column(name = "max_salary")
    private long maxSalary;

    private List<Employees> employees;

}
