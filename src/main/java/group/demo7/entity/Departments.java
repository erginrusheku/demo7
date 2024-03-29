package group.demo7.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DEPARTMENTS")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id", nullable = false)
    private Long departmentId;
    @Column(name = "department_name")
    private String departmentName;
    @ManyToOne
    @JoinColumn(name="location_id")
    private Locations location;
    @OneToMany
    private List<Employees> employees;

}
