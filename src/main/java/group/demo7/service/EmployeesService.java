package group.demo7.service;

import group.demo7.dto.EmployeesDTO;

import java.util.List;

public interface EmployeesService {
    List<EmployeesDTO> getAllEmployees();
    EmployeesDTO getEmployeeById(long employeeId);
    EmployeesDTO addEmployee(EmployeesDTO employeesDTO);
    EmployeesDTO updateEmployees(long employeeId, EmployeesDTO updatedEmployeesDTO);
    void deleteEmployeesById(long id);

}
