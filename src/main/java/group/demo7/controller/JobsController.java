package group.demo7.controller;

import group.demo7.dto.JobsDTO;
import group.demo7.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobsController {
    @Autowired
    private JobsService jobsService;


    @GetMapping("/getJobs")
    public ResponseEntity<List<JobsDTO>> jobs(){
        return ResponseEntity.ok(jobsService.jobs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobsDTO> getJobsById(@PathVariable long jobsId){
        return ResponseEntity.ok(jobsService.getJobsById(jobsId));
    }

    @PostMapping("/addJobs")
    public ResponseEntity<JobsDTO> addJobs(@RequestBody JobsDTO jobsDTO){
        JobsDTO addJobs = jobsService.addJobs(jobsDTO);
        return new ResponseEntity<>(addJobs,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JobsDTO> updateJobs(@PathVariable long jobsId, @RequestBody JobsDTO updatedJobs){
        JobsDTO updatedJobsDTO = jobsService.updateJobs(jobsId, updatedJobs);
        return new ResponseEntity<>(updatedJobsDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJobsById(@PathVariable long jobsId){
        jobsService.deleteJobsById(jobsId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
