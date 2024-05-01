package com.example.JobApp.comapny;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class companyController {
	
	@Autowired
	 private companyService companyService;
	
	@GetMapping
	public ResponseEntity<List<Company>> findAll(){
		return ResponseEntity.ok(companyService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<String> createCompany(@RequestBody Company company){
		companyService.createCompany(company);
		return new ResponseEntity<>("Company Created",HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> findById(@PathVariable long id){
		Company company = companyService.findbyId(id);
		if(company != null) {
			return new ResponseEntity<Company>(company,HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id){
		boolean comapany =  companyService.deleteById(id);
		if(comapany) {
			return new ResponseEntity<>("Company deleted successfully",HttpStatus.OK);
		}
		return new ResponseEntity<>("Record cannot be deleted",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateById(@PathVariable long id, @RequestBody Company updatedCompany){
		boolean  company= companyService.updateById(id,updatedCompany);
		if(company) {
			return new ResponseEntity<>("Record updated",HttpStatus.CREATED);
		}
		return  new ResponseEntity<String>("Record Not Found",HttpStatus.NON_AUTHORITATIVE_INFORMATION);
	}

}
