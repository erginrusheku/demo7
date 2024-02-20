package group.demo7.controller;

import group.demo7.dto.DepartmentsDTO;
import group.demo7.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
    @Autowired
    private DepartmentsService departmentsService;
    @GetMapping
    public ResponseEntity<List<DepartmentsDTO>> departmentsList(){
        return ResponseEntity.ok(departmentsService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentsDTO> getDepartmentsById(@PathVariable long departmentsId){
        return ResponseEntity.ok(departmentsService.getDepartmentsById(departmentsId));
    }

    @PostMapping
    public ResponseEntity<DepartmentsDTO> addDepartments(@RequestBody DepartmentsDTO departments){
        DepartmentsDTO addDepartments = departmentsService.addDepartments(departments);
        return new ResponseEntity<>(addDepartments, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentsDTO> updateEmployees(@PathVariable long departmentsId, @RequestBody DepartmentsDTO updateDepartments){
        DepartmentsDTO updateDepartment = departmentsService.updateDepartments(departmentsId, updateDepartments);
        return new ResponseEntity<>(updateDepartment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartmentsById(@PathVariable long id){
        departmentsService.deleteDepartmentsById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
