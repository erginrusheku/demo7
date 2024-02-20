package group.demo7.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEPENDENTS")
public class Dependents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "dependent_id")
    private long dependentId;

    @Column(name ="first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "relationship")
    private String relationship;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employees;


}
