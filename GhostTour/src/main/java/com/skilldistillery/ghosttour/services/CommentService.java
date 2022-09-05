package com.skilldistillery.ghosttour.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.ghosttour.entities.Comment;

@Service
public interface CommentService {

	List<Comment> listAllComments();
	
	List<Comment> getAllCommentsByPostId(int tourId, int reviewId);
	
	Comment createCommentforReview(int reviewId, Comment comment);
		
	Comment updateComment(Comment comment, int reviewId);
	
	Comment findById(int id);
	
	boolean deleteComment(int id);
}
