package group.demo7.controller;

import group.demo7.dto.EmployeesDTO;
import group.demo7.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs/employees")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping
    public ResponseEntity<List<EmployeesDTO>> employeesList(){
        return ResponseEntity.ok(employeesService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeesDTO> getEmployeesById(@PathVariable long employeesId){
        return ResponseEntity.ok(employeesService.getEmployeeById(employeesId));
    }

    @PostMapping
    public ResponseEntity<EmployeesDTO> addEmployees(@RequestBody EmployeesDTO employees){
        EmployeesDTO addEmployees = employeesService.addEmployee(employees);
        return new ResponseEntity<>(addEmployees, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeesDTO> updateEmployees(@PathVariable long employeesId, @RequestBody EmployeesDTO updateEmployees){
        EmployeesDTO updateEmployees1 = employeesService.updateEmployees(employeesId, updateEmployees);
        return new ResponseEntity<>(updateEmployees1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeesById(@PathVariable long id){
        employeesService.deleteEmployeesById(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
