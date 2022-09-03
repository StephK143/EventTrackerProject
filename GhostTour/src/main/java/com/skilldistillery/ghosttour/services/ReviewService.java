package com.skilldistillery.ghosttour.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.ghosttour.entities.Review;

@Service
public interface ReviewService {

	List<Review> listAllReviews();
}
