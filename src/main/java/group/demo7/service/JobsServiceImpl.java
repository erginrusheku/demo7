package group.demo7.service;

import group.demo7.dto.EmployeesDTO;
import group.demo7.dto.JobsDTO;
import group.demo7.entity.Employees;
import group.demo7.entity.Jobs;
import group.demo7.repository.JobsRepository;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobsServiceImpl  implements JobsService{

    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<JobsDTO> jobs() {
        List<Jobs> jobsList = jobsRepository.findAll();
        return jobsList.stream().map(job -> modelMapper.map(job, JobsDTO.class)).collect(Collectors.toList());
    }

    @Override
    public JobsDTO getJobsById(long jobId) {
        Optional<Jobs> jobs = jobsRepository.findById(jobId);
        return jobs.stream().map(job -> modelMapper.map(job, JobsDTO.class)).findAny().orElse(null);

    }
    @Override
    public JobsDTO addJobs(JobsDTO jobs) {
        if(jobs == null || jobs.getEmployees() == null){

            return null;
        }

        Jobs jobs1 = modelMapper.map(jobs, Jobs.class);

        List<Employees> employees = jobs.getEmployees().stream().map(employeeDTO -> {
            Employees employees1 = modelMapper.map(employeeDTO, Employees.class);
            employees1.setJobs(jobs1);
            return employees1;
        }).toList();

        jobs1.setEmployees(employees);

        Jobs savedJobs = jobsRepository.save(jobs1);

        return modelMapper.map(savedJobs, JobsDTO.class);
    }

    @Override
    public JobsDTO updateJobs(long jobId, JobsDTO jobs) {
        if (jobs != null) {
            // Find existing job by ID
            Jobs existingJobs = jobsRepository.findById(jobId).orElse(null);

            if (existingJobs != null) {
                // Update existing job details
                modelMapper.map(jobs, existingJobs);

                // Update or add employees
                if (jobs.getEmployees() != null) {
                    List<Employees> updatedEmployees = new ArrayList<>();

                    for (EmployeesDTO employeesDTO : jobs.getEmployees()) {
                        if (employeesDTO.getEmployeeId() != null) {
                            // Update existing employee
                            Employees existingEmployee = existingJobs.getEmployees().stream()
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
                            newEmployee.setJobs(existingJobs);
                            updatedEmployees.add(newEmployee);
                        }
                    }

                    // Update employees list in the job
                    existingJobs.setEmployees(updatedEmployees);
                }

                // Save updated job and return the mapped DTO
                Jobs updatedJobs = jobsRepository.save(existingJobs);
                return modelMapper.map(updatedJobs, JobsDTO.class);
            }
        }
        return null;
    }

    @Override
    public void deleteJobsById(long deleteJobsById) {
      jobsRepository.deleteById(deleteJobsById);
    }
}
