package group.demo7.service;

import group.demo7.dto.JobsDTO;
import group.demo7.entity.Jobs;
import group.demo7.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobsServiceImpl  implements JobsService{

    @Autowired
    private JobsRepository jobsRepository;


    @Override
    public List<JobsDTO> jobs() {
        return null;
    }

    @Override
    public JobsDTO getJobsById(long jobId) {
        return null;
    }

    @Override
    public JobsDTO addJobs(JobsDTO jobs) {
        return null;
    }

    @Override
    public JobsDTO updateJobs(long jobId, JobsDTO jobs) {
        return null;
    }

    @Override
    public void deleteJobsById(long deleteJobsById) {
      jobsRepository.deleteById(deleteJobsById);
    }
}
