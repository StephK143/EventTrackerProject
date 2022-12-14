package com.skilldistillery.ghosttour.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.ghosttour.entities.Review;
import com.skilldistillery.ghosttour.services.ReviewService;

@RestController
@RequestMapping("api")
public class ReviewController {

	@Autowired
	private ReviewService reviewServ;


	@GetMapping("reviews")
	public List<Review> listAllReviews() {
		return reviewServ.listAllReviews();
	}

	@GetMapping("reviews/{id}")
	public Review getReviewById(@PathVariable int id, HttpServletResponse res) {
		Review review = reviewServ.findById(id);
		if (review == null) {
			res.setStatus(404);
		}
		return review;
	}

	@PostMapping("tours/{tourId}/reviews")
	public Review addReviewToTour(@PathVariable int tourId,
			@RequestBody Review review, 
			HttpServletResponse resp,
			HttpServletRequest req) {
		review = reviewServ.createReviewForTour(tourId, review);
		try {
			if (review == null) {
				resp.setStatus(404);
			} else {
				resp.setStatus(201);
				StringBuffer url = req.getRequestURL();
				resp.setHeader("Location", url.toString());
			}
		} catch (Exception e) {
			resp.setStatus(404);
		}
		return review;
	}

	@PutMapping("reviews/{reviewId}")
	public Review updateReview(
			@RequestBody Review review, 
			@PathVariable int reviewId, 
			HttpServletResponse resp) {
		Review updated = null;

		try {
			updated = reviewServ.update(review, reviewId);

		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}

		return updated;

	}
	
	@DeleteMapping("reviews/{id}")
	public Boolean deleteReview(
			@PathVariable int id,
			HttpServletResponse resp) {
		Boolean deleted = reviewServ.deleteReview(id);
		if (deleted) {
			resp.setStatus(204);
		} else {
			resp.setStatus(404);
		}
		
		return deleted;
	}

}












