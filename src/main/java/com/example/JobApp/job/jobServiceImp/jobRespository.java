package com.example.JobApp.job.jobServiceImp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JobApp.job.Job;
//import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

public interface jobRespository extends JpaRepository<Job, Long> {

}
