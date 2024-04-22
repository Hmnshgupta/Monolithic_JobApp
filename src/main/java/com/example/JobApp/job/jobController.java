package com.example.JobApp.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JobApp.comapny.Company;

@RestController
public class jobController {
	@Autowired
	private jobService jobService;
	
	@GetMapping("/jobs")
	public ResponseEntity<List<Job>> findAll(){
		return  ResponseEntity.ok(jobService.findall()) ;
	}
	
	@PostMapping("/jobs")
	public ResponseEntity<String> createjob(@RequestBody Job job) {
		jobService.createjob(job);
		Company c = job.getCompany();
		return new ResponseEntity<>("Job successfully added",HttpStatus.CREATED);
	}
	
	@GetMapping("/jobs/{id}")
	public ResponseEntity<Job> findById(@PathVariable long id){
		Job job= jobService.findById(id);
		if(job!=null) {
			return new ResponseEntity<Job>(job,HttpStatus.OK);
		}
		return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		boolean delete = jobService.deleteById(id);
		if(delete) {
			return new ResponseEntity<String>("Delete successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Not deleted ",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateById(@PathVariable long id, @RequestBody Job updatedjob){
		boolean update = jobService.updateById(id,updatedjob);
				if(update) {
					return new ResponseEntity<>("Job updated successfully",HttpStatus.OK);
				}
				return new ResponseEntity<>("Not Updated",HttpStatus.NOT_MODIFIED);
	}
	
	
	
	

}
