package com.example.JobApp.review.reviewServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JobApp.comapny.Company;
import com.example.JobApp.comapny.companyService;
import com.example.JobApp.review.Review;
import com.example.JobApp.review.reviewService;

@Service
public class reviewServiceImpl implements reviewService{
	@Autowired
	private reviewRepository reviewRepository;
	@Autowired
	private companyService companyService;

	@Override
	public List<Review> getAllReviews(long companyId) {
		List<Review> reveiws = reviewRepository.findByCompanyId(companyId);
		return reveiws;
		
	}

	@Override
	public void createReview(long companyId, Review review) {
		Company company = companyService.findbyId(companyId);
		if(company != null) {
			review.setCompany(company);
			reviewRepository.save(review);
		}
		
		
	}

	@Override
	public Review getReviewById(Long companyId, Long reviewId) {
		List<Review> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews.stream()
				.filter(review ->  review.getId().equals(reviewId))
				.findFirst()
				.orElse(null);
		 
	}

	@Override
	public boolean updateReview(long companyId, long reviewId,Review updatedReview) {
		Company company = companyService.findbyId(companyId);
		if(company != null) {
			updatedReview.setCompany(company);
			updatedReview.setId(reviewId);
			reviewRepository.save(updatedReview);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean deleteReviewById(long companyId, long reviewId) {
		Company company = companyService.findbyId(companyId);
		if(company != null && reviewRepository.existsById(reviewId)) {
			Review review = reviewRepository.findById(reviewId).orElse(null);
			Company company1 = review.getCompany();
			company1.getReviews().remove(review);
			companyService.updateById(companyId, company1);
			reviewRepository.deleteById(reviewId);
			return true;
		}
		return false;
	}
	
	

}
