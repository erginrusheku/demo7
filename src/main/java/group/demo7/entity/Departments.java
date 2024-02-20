package group.demo7.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DEPARTMENTS")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id", nullable = false)
    private long departmentId;
    @Column(name = "department_name")
    private String departmentName;
    @ManyToOne
    @JoinColumn(name="location_id")
    private long locationId;

}
