package com.example.JobApp.job;

import java.util.List;



public interface jobService {
	List<Job> findall();
	void createjob(Job job);
	Job findById(long id);
	boolean deleteById(Long id);
	boolean updateById(long id,Job job);

}
