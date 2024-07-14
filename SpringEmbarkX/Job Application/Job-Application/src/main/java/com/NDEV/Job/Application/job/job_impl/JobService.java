package com.NDEV.Job.Application.job.job_impl;

import com.NDEV.Job.Application.job.Job;
import com.NDEV.Job.Application.job.JobModel;
import com.NDEV.Job.Application.job.JobRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService implements JobModel {

    private List<Job> jobs = new ArrayList<>();
    private Integer NextId = 1;
    private JobRepository repository;

    public JobService(JobRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Job> findAll() {
        return repository.findAll();
    }

    @Override
    public void createJob(Job job) {
        repository.save(job);
    }

    @Override
    public Job findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Integer id) {
        try
        {
            repository.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }

    @Override
    public boolean updateJobById(Integer id, Job updateJob) {

        Optional<Job> optionalJobId = repository.findById(id);

        if(optionalJobId.isPresent())
        {
            Job job = optionalJobId.get();

            job.setTitle(updateJob.getTitle());
            job.setDescription(updateJob.getDescription());
            job.setMinSalary(updateJob.getMinSalary());
            job.setMaxSalary(updateJob.getMaxSalary());
            repository.save(job);
            return true;
        }

        return false;
    }


}
