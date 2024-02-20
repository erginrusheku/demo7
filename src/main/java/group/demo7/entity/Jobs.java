package group.demo7.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "JOBS")
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private long jobId;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "min_salary")
    private long minSalary;

    @Column(name = "max_salary")
    private long maxSalary;

}
