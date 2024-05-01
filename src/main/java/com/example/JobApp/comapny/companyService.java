package com.example.JobApp.comapny;

import java.util.List;



public interface companyService  {
	
	List<Company> findAll();
	void createCompany(Company company);
	Company findbyId(long id);
	boolean deleteById(long id);
	boolean updateById(long id,Company updatedCompany); 
	

}
