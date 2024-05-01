package com.example.JobApp.review.reviewServiceImpl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JobApp.review.Review;

public interface reviewRepository extends JpaRepository<Review, Long> {

	List<Review> findByCompanyId(Long companyId);


}
