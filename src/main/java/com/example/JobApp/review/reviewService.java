package com.example.JobApp.review;

import java.util.List;

public interface reviewService {
	List<Review> getAllReviews(long companyId);

	void createReview(long companyId, Review review);

	Review getReviewById(Long companyId, Long reviewId);

	boolean updateReview(long companyId, long reviewId,Review review);

	boolean deleteReviewById(long companyId, long reviewId); 
	
	 

}
