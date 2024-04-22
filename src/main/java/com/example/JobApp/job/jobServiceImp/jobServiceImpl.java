package com.example.JobApp.job.jobServiceImp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JobApp.job.Job;
import com.example.JobApp.job.jobService;

@Service
public class jobServiceImpl implements jobService{

	@Autowired
	private jobRespository jobRespository;
	
	@Override
	public List<Job> findall() {
		// TODO Auto-generated method stub
		return jobRespository.findAll();
	}

	@Override
	public void createjob(Job job) {
		// TODO Auto-generated method stub
		jobRespository.save(job);
		
	}

//	@Override (without JPA)
//	public Job findById(long id) {
//		// TODO Auto-generated method stub
//		for(Job job : jobs) {
//			if(job.getId().equals(id)) {
//				return job;
//			}
//		}
//		return null;
//	}
	
	@Override
	public Job findById(long id) {
		return jobRespository.findById(id).orElse(null);
		
	}

//	@Override()without JPA
//	public boolean deleteById(long id) {
//		// TODO Auto-generated method stub
//		Iterator<Job> iterator = jobs.iterator();
//		while(iterator.hasNext()) {
//			Job job = iterator.next();
//			if(job.getId().equals(id)) {
//				iterator.remove();
//				return true;
//			}
//		}
//		
//		return false;
//	}
	
	@Override
	public boolean deleteById(Long id) {
		if (jobRespository.existsById(id)) {
			jobRespository.deleteById(id);
			return true;
		}
		return false;
	}
		
	

//	@Override without JPA
//	public boolean updateById(long id, Job updatedjob) {
//		// TODO Auto-generated method stub
//		for(Job job : jobs) {
//			if(job.getId().equals(id)) {
//				job.setTitle(updatedjob.getTitle());
//				job.setDescription(updatedjob.getDescription());
//				job.setMaxSalary(updatedjob.getMaxSalary());
//				job.setMinSalary(updatedjob.getMinSalary());
//				job.setLocation(updatedjob.getLocation());
//				return true;
//			}
//			
//		}
//		return false;
//	}
	
	@Override
	public boolean updateById(long id, Job updatedjob) {
		Optional<Job> jobOptional = jobRespository.findById(id);
		
			if(jobOptional.isPresent()) {
				Job job = jobOptional.get();
				job.setTitle(updatedjob.getTitle());
				job.setDescription(updatedjob.getDescription());
				job.setMaxSalary(updatedjob.getMaxSalary());
				job.setMinSalary(updatedjob.getMinSalary());
				job.setLocation(updatedjob.getLocation());
				jobRespository.save(job);
				return true;
			}
			
		
		return false;
	}

}
