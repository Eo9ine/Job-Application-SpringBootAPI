package com.NDEV.Job.Application.job;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobModel {
    List<Job> findAll();
    void createJob(Job job);
    Job findById(Integer id);
    boolean deleteById(Integer id);
    boolean updateJobById(Integer id, Job job);
}
