package group.demo7.repository;

import group.demo7.entity.Regions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionsRepository extends JpaRepository<Regions, Long> {
}
