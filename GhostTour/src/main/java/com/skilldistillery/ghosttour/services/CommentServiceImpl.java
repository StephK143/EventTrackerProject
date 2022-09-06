package com.skilldistillery.ghosttour.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.ghosttour.entities.Comment;
import com.skilldistillery.ghosttour.entities.Review;
import com.skilldistillery.ghosttour.repositories.CommentRepository;
import com.skilldistillery.ghosttour.repositories.ReviewRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private ReviewRepository reviewRepo;

	@Override
	public List<Comment> listAllComments() {
		return commentRepo.findAll();
	}

	@Override
	public Comment createCommentforReview(int reviewId, Comment comment) {
		Optional<Review> reviewOp = reviewRepo.findById(reviewId);
		if (reviewOp.isPresent()) {
			Review review = reviewOp.get();
			comment.setReview(review);
			commentRepo.saveAndFlush(comment);
			return comment;
		}
		return null;
	}

	@Override
	public Comment updateComment(Comment comment, int commentId) {
		Comment existing = findById(comment.getId());
		if (existing == null) {
			return null;
		}
		
		existing.setName(comment.getName());
		existing.setComment(comment.getComment());
		existing.setImage(comment.getImage());
		return commentRepo.saveAndFlush(existing);
	}

	@Override
	public Comment findById(int id) {
		Comment c = null;
		Optional<Comment> commentOp = commentRepo.findById(id);
		if (commentOp.isPresent()) {
			c = commentOp.get()	;
		}
		return c;
	}

	@Override
	public boolean deleteComment(int id) {
		commentRepo.deleteById(id);
		return !commentRepo.existsById(id);
	}

	@Override
	public List<Comment> getAllCommentsByPostId(int tourId, int reviewId) {

		return commentRepo.findByReviewTourId(tourId);
	}

}
