package com.skilldistillery.ghosttour.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.ghosttour.entities.Review;
import com.skilldistillery.ghosttour.repositories.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepo;
	
	@Override
	public List<Review> listAllReviews() {
		return reviewRepo.findAll();
	}

}
