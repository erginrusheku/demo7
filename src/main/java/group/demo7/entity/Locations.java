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
@Table(name = "LOCATIONS")
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", nullable = false)
    private Long locationId;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "postal_code")
    private Long postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "state_province")
    private String stateProvince;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Countries countries;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Departments> departments;

}
