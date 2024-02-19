package group.demo7.repository;

import group.demo7.entity.Locations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsRepository extends JpaRepository<Locations, Long> {
}
