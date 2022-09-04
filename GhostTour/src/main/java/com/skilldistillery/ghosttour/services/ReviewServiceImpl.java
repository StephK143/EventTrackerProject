package com.skilldistillery.ghosttour.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

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
	public Review createReviewForTour(int tourId, Review review) {
		Optional<Tour> tourOp = tourRepo.findById(tourId);
		if (tourOp.isPresent()) {
			Tour tour = tourOp.get();
			review.setTour(tour);
			reviewRepo.saveAndFlush(review);
			return review;
		}

		return null;
	}

	@Override
	public Review update(Review review, int reviewId) {
		Review existing = findById(review.getId());
		if (existing == null) {
			return null;
		}
		if (review.getTitle() == null) {
			existing.setTitle(review.getTitle());
		}
		existing.setName(review.getDescription());
		existing.setEmail(review.getEmail());
		existing.setDescription(review.getDescription());
		existing.setPricePerPerson(review.getPricePerPerson());
		return reviewRepo.saveAndFlush(existing);
	}

	@Override
	public Review findById(int id) {
		Review r = null;
		Optional<Review> reviewOp = reviewRepo.findById(id);
		if (reviewOp.isPresent()) {
			r = reviewOp.get();
		}
		return r;
	}

	@Override
	public boolean deleteReview(int id) {
		reviewRepo.deleteById(id);
		return !reviewRepo.existsById(id);
	}
}
