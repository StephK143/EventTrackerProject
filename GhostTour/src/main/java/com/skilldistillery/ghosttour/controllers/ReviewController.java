package com.skilldistillery.ghosttour.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Review> listAllReviews(){
		return reviewServ.listAllReviews();
	}

}
