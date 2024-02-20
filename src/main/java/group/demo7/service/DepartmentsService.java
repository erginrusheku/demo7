package group.demo7.service;

import group.demo7.dto.DepartmentsDTO;
import group.demo7.entity.Departments;

import java.util.List;

public interface DepartmentsService {
    List<DepartmentsDTO> getAllDepartments();
    DepartmentsDTO getDepartmentsById(long departmentsId);
    DepartmentsDTO addDepartments(DepartmentsDTO employeesDTO);
    DepartmentsDTO updateDepartments(long departmentsId, DepartmentsDTO updatedDepartmentsDTO);
    void deleteDepartmentsById(long id);
}
