package group.demo7.service;

import group.demo7.dto.JobsDTO;

import java.util.List;

public interface JobsService {
    List<JobsDTO> jobs();

    JobsDTO getJobsById(long jobId);

    JobsDTO addJobs(JobsDTO jobs);

    JobsDTO updateJobs(long jobId, JobsDTO jobs);

    void deleteJobsById(long deleteJobsById);
}
