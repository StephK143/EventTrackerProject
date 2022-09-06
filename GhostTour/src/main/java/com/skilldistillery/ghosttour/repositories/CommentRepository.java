package com.skilldistillery.ghosttour.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.ghosttour.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	List<Comment> findByReviewTourId(int tourId);
	
}
