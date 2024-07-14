package com.NDEV.Job.Application.job;

import com.NDEV.Job.Application.job.job_impl.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService)
    {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{job-id}")
    public ResponseEntity<Job> findById(
            @PathVariable("job-id") Integer id
    )
    {
        return new ResponseEntity<>(jobService.findById(id),HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<String> createJob(
            @RequestBody Job job
    )
    {
        jobService.createJob(job);
        return new ResponseEntity<>("JOB ADDED SUCCESSFULLY",HttpStatus.OK);
    }

    @DeleteMapping("/{job-id}")
    public ResponseEntity<String> deleteById(
            @PathVariable("job-id") Integer id
    )
    {
        boolean isDeleted = jobService.deleteById(id);
        if(isDeleted)
            return new ResponseEntity<>("Job Deleted Successfully",HttpStatus.OK);
        return new ResponseEntity<>("No job found with id: "+ id ,HttpStatus.NOT_FOUND);


    }

    @PutMapping("/{job-id}")
    public ResponseEntity<String> updateJob(
            @PathVariable("job-id") Integer id,@RequestBody Job job
    )
    {
        boolean updated = jobService.updateJobById(id,job);
        if(updated)
            return new ResponseEntity<>("Job updated successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
