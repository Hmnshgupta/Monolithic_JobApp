package com.example.JobApp.comapny.companyServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JobApp.comapny.Company;
import com.example.JobApp.comapny.companyService;

@Service
public class companyServiceImp implements companyService {
	
	@Autowired
	private companyRepository companyRepository;

	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();		
	}

	@Override
	public void createCompany(Company company) {
		// TODO Auto-generated method stub
		companyRepository.save(company);
		
	}

	@Override
	public Company findbyId(long id) {
		// TODO Auto-generated method stub
		return companyRepository.findById(id).orElse(null);
		
	}

	@Override
	public boolean deleteById(long id) {
		// TODO Auto-generated method stub
		if(companyRepository.existsById(id)) {
			companyRepository.deleteById(id);
			return true;
		}
		return false;
		
	}

	@Override
	public boolean updateById(long id, Company updatedCompany) {
		if(companyRepository.existsById(id)) {
			Optional<Company> companyOptional = companyRepository.findById(id);
			if(companyOptional.isPresent()) {
				Company company = companyOptional.get();
				company.setcName(updatedCompany.getcName());
				company.setLocation(updatedCompany.getLocation());
				company.setJobs(updatedCompany.getJobs());
				companyRepository.save(company);
				return true;
			}
		}
		return false;
	}

}
