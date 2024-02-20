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
@Table(name = "REGIONS")
public class Regions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "region_id", nullable = false)
    private Long regionId;

    @Column(name = "region_name")
    private String regionName;

    private List<Countries> countries;

}
