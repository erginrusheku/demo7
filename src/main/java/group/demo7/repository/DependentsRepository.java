package group.demo7.repository;

import group.demo7.entity.Dependents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependentsRepository extends JpaRepository<Dependents, Long> {
}
