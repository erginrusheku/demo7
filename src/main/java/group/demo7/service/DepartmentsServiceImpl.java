package group.demo7.service;


import group.demo7.dto.DepartmentsDTO;
import group.demo7.dto.EmployeesDTO;
import group.demo7.entity.Departments;
import group.demo7.entity.Employees;
import group.demo7.repository.DepartmentsRepository;
import jakarta.persistence.Id;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentsServiceImpl implements DepartmentsService{

    @Autowired
    private DepartmentsRepository departmentsRepository;

    private ModelMapper modelMapper;

    @Override
    public List<DepartmentsDTO> getAllDepartments() {
        List<Departments> departments = departmentsRepository.findAll();
     return departments.stream().map(departments1 -> modelMapper.map(departments1,DepartmentsDTO.class)).collect(Collectors.toList());
    }


    @Override
    public DepartmentsDTO getDepartmentsById(long departmentsId) {
        Optional<Departments> departments = departmentsRepository.findById(departmentsId);

        return departments.map(departments1 -> modelMapper.map(departments1, DepartmentsDTO.class))
                .orElse(null);
    }
    @Override
    public DepartmentsDTO addDepartments(DepartmentsDTO departments) {
        if(departments == null || departments.getEmployees() == null){

            return null;
        }

        Departments departments1 = modelMapper.map(departments, Departments.class);

        List<Employees> employees = departments.getEmployees().stream().map(employeeDTO -> {
            Employees employees1 = modelMapper.map(employeeDTO, Employees.class);
            employees1.setJobId(departments1.getDepartmentId());
            return employees1;
        }).toList();

        departments1.setEmployees(employees);

        Departments savedDepartments = departmentsRepository.save(departments1);

        return modelMapper.map(savedDepartments, DepartmentsDTO.class);
    }



    @Override
    public DepartmentsDTO updateDepartments(long departmentId, DepartmentsDTO departments) {
        if (departments != null) {
            // Find existing job by ID
            Departments existingDepartments = departmentsRepository.findById(departmentId).orElse(null);

            if (existingDepartments != null) {
                // Update existing job details
                modelMapper.map(departments, existingDepartments);

                // Update or add employees
                if (departments.getEmployees() != null) {
                    List<Employees> updatedEmployees = new ArrayList<>();

                    for (EmployeesDTO employeesDTO : departments.getEmployees()) {
                        if (employeesDTO.getEmployeeId() != null) {
                            // Update existing employee
                            Employees existingEmployee = existingDepartments.getEmployees().stream()
                                    .filter(e -> e.getEmployeeId().equals(employeesDTO.getEmployeeId()))
                                    .findFirst()
                                    .orElse(null);

                            if (existingEmployee != null) {
                                modelMapper.map(employeesDTO, existingEmployee);
                                updatedEmployees.add(existingEmployee);
                            }
                        } else {
                            // Add new employee
                            Employees newEmployee = modelMapper.map(employeesDTO, Employees.class);
                            newEmployee.setDepartmentId(existingDepartments.getDepartmentId());
                            updatedEmployees.add(newEmployee);
                        }
                    }

                    // Update employees list in the job
                    existingDepartments.setEmployees(updatedEmployees);
                }

                // Save updated job and return the mapped DTO
                Departments updatedDepartments = departmentsRepository.save(existingDepartments);
                return modelMapper.map(updatedDepartments, DepartmentsDTO.class);
            }
        }
        return null;
    }

    @Override
    public void deleteDepartmentsById(long id) {
        departmentsRepository.deleteById(id);
    }
}
