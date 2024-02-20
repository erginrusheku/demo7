package group.demo7.repository;

import group.demo7.entity.Countries;
import group.demo7.entity.Departments;
import group.demo7.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Long>{

}
