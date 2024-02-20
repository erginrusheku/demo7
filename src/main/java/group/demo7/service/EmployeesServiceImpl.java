package group.demo7.service;

import group.demo7.dto.DependentsDTO;
import group.demo7.dto.EmployeesDTO;
import group.demo7.entity.Dependents;
import group.demo7.entity.Employees;
import group.demo7.repository.EmployeesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeesServiceImpl implements EmployeesService{
    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<EmployeesDTO> getAllEmployees() {
        List<Employees> employeesList = employeesRepository.findAll();
        return employeesList.stream()
                .map(employee -> modelMapper.map(employee, EmployeesDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeesDTO getEmployeeById(long employeeId) {
        Optional<Employees> employees = employeesRepository.findById(employeeId);
        return employees.stream().map(employee -> modelMapper.map(employee,EmployeesDTO.class))
                .findAny().orElse(null);
    }

    @Override
    public EmployeesDTO addEmployee(EmployeesDTO employeesDTO) {
        if(employeesDTO == null || employeesDTO.getDependents() == null){
            return null;
        }
        Employees employees = modelMapper.map(employeesDTO, Employees.class);

        List<Dependents> dependents = employeesDTO.getDependents().stream().map(dependentsDTO -> {
            Dependents dependents1 = modelMapper.map(dependentsDTO, Dependents.class);
            dependents1.setEmployees(employees);
            return  dependents1;
        }).toList();
        employees.setDependentsList(dependents);

        Employees savedEmployees = employeesRepository.save(employees);

        return modelMapper.map(savedEmployees, EmployeesDTO.class);
    }

    @Override
    public EmployeesDTO updateEmployees(long employeeId, EmployeesDTO updatedEmployeesDTO) {
        if (updatedEmployeesDTO != null) {
            Employees existingEmployee = employeesRepository.findById(employeeId).orElse(null);

            if (existingEmployee != null) {
                modelMapper.map(updatedEmployeesDTO, existingEmployee);

                if (updatedEmployeesDTO.getDependents() != null) {
                    List<Dependents> updatedDependents = new ArrayList<>();

                    for (DependentsDTO dependentsDTO : updatedEmployeesDTO.getDependents()) {
                        if (dependentsDTO.getDependentId() != null) {
                            Dependents existingDependent = existingEmployee.getDependentsList().stream().filter(d -> d.getDependentId().equals(dependentsDTO.getDependentId())).findFirst().orElse(null);

                            if (existingDependent != null) {
                                modelMapper.map(dependentsDTO, existingDependent);
                                updatedDependents.add(existingDependent);
                            }
                        } else {
                            Dependents newDependents = modelMapper.map(dependentsDTO, Dependents.class);
                            newDependents.setEmployees(existingEmployee);
                            updatedDependents.add(newDependents);
                        }
                    }

                    existingEmployee.setDependentsList(updatedDependents);
                }
                Employees updateEmployee = employeesRepository.save(existingEmployee);
                return modelMapper.map(updateEmployee, EmployeesDTO.class);
            }
        }
        return null;
    }


    @Override
    public void deleteEmployeesById(long id) {
        employeesRepository.deleteById(id);
    }
}
