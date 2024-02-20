package group.demo7.controller;

import group.demo7.dto.DependentsDTO;
import group.demo7.service.DependentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dependents")
public class DependentsController {
    @Autowired
    private DependentsService dependentsService;


    public ResponseEntity<List<DependentsDTO>> getAllDependents(){
        return new ResponseEntity<>(dependentsService.dependentsList(), HttpStatus.OK);
    }

    public ResponseEntity<DependentsDTO> getById(@PathVariable long id){
        return new ResponseEntity<>(dependentsService.getById(id), HttpStatus.OK);
    }

    public ResponseEntity<DependentsDTO> addDependents(@RequestBody DependentsDTO dependentsDTO){
        return new ResponseEntity<>(dependentsService.addDependents(dependentsDTO),HttpStatus.CREATED);
    }

    public ResponseEntity<DependentsDTO> updateDependents(@PathVariable long id, @RequestBody DependentsDTO dependentsDTO){
        return new ResponseEntity<>(dependentsService.updateDependents(id, dependentsDTO), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Void> deleteDependents(@PathVariable long id){
        dependentsService.deleteDependents(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
