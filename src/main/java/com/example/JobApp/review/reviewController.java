package com.example.JobApp.review;

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

import com.example.JobApp.comapny.Company;
import com.example.JobApp.review.reviewServiceImpl.reviewRepository;

import ch.qos.logback.core.joran.conditional.IfAction;

@RestController
@RequestMapping("/companies/{companyId}")
public class reviewController {
	
	@Autowired
	private reviewService reviewService;
	
	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> findbyId(@PathVariable long companyId){
		List<Review> reviews = reviewService.getAllReviews(companyId);
		return new ResponseEntity<>(reviews,HttpStatus.OK);
	}
	
	@PostMapping("/reviews")
	public ResponseEntity<String> createReveiw(@PathVariable long companyId,@RequestBody Review review){
		reviewService.createReview(companyId,review);
		return new ResponseEntity<String>("Review added successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<Review> getReviewById(@PathVariable long companyId, @PathVariable long reviewId){
		Review review = reviewService.getReviewById(companyId,reviewId);
		if(review != null) {
			return new ResponseEntity<Review>(review,HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/reviews/{reviewId}")
	public ResponseEntity<String> updateReview(@PathVariable long companyId, @PathVariable long reviewId,@RequestBody Review review){
		boolean isTrue = reviewService.updateReview(companyId,reviewId,review);
		if(isTrue){
			return new ResponseEntity<>("Review Updated successfully", HttpStatus.OK);
		}
			else {
				return new ResponseEntity<>("Review not Updated successfully", HttpStatus.NOT_FOUND);
			}
	}
	
	@DeleteMapping("/reviews/{reviewId}")
	public ResponseEntity<String> deleteReviewById(@PathVariable long companyId, @PathVariable long reviewId){
		boolean isDeleted = reviewService.deleteReviewById(companyId,reviewId);
		if(isDeleted){
			return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Not Deleted ",HttpStatus.NOT_FOUND);
		}
	}

}
