package com.skilldistillery.ghosttour.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.ghosttour.entities.Review;
import com.skilldistillery.ghosttour.entities.Tour;
import com.skilldistillery.ghosttour.repositories.ReviewRepository;
import com.skilldistillery.ghosttour.repositories.TourRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private TourRepository tourRepo;
	
	@Override
	public List<Review> listAllReviews() {
		return reviewRepo.findAll();
	}

	@Override
	public Review getReviewById(int reviewId) {
		return reviewRepo.findById(reviewId);
	}

	@Override
	public Review createReviewForTour(
			int tourId, 
			Review review) {
		Optional<Tour> tourOp = tourRepo.findById(tourId);
		if (tourOp.isPresent()) {
			Tour tour = tourOp.get();
			review.setTour(tour);
			reviewRepo.saveAndFlush(review);
			return review;
		}
		
		return null;
	}

}











