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

import com.skilldistillery.ghosttour.entities.Comment;
import com.skilldistillery.ghosttour.services.CommentService;

@RestController
@RequestMapping("api")
public class CommentController {
	
	@Autowired
	private CommentService commentServ;
	
	
	@GetMapping("comments")
	public List<Comment> listAllComments(){
		return commentServ.listAllComments();
	}
	
	@GetMapping("comments/{id}")
	public Comment getCommentById(
			@PathVariable int id, 
			HttpServletResponse resp) {
		Comment comment = commentServ.findById(id);
		if (comment == null) {
			resp.setStatus(404);
		}
		return comment;
	}
	
	@GetMapping("tours/{tourId}/reviews/{reviewId}/comments")
	public List<Comment> getAllCommentsByTourId(
			@PathVariable int tourId, 
			@PathVariable int reviewId,
			HttpServletResponse resp) {
		List<Comment> comments = commentServ.getAllCommentsByPostId(tourId, reviewId);
		if (comments == null) {
			resp.setStatus(404);
		}
		return comments;
	}
	
	@PostMapping("reviews/{reviewId}/comments")
	public Comment addCommentToReview(
			@PathVariable int reviewId, 
			@RequestBody Comment comment, 
			HttpServletResponse resp, 
			HttpServletRequest req) {
		comment = commentServ.createCommentforReview(reviewId, comment);
		try {
			if (comment == null) {
				resp.setStatus(404);
			} else {
				resp.setStatus(201);
				StringBuffer url = req.getRequestURL();
				resp.setHeader("Location", url.toString());
			}
		} catch (Exception e) {
			resp.setStatus(404);
		}
		
		
		return comment;
	}
	

		@PutMapping("comments/{commentId}")
		public Comment updateComment(
				@RequestBody Comment comment, 
				@PathVariable int commentId, 
				HttpServletResponse resp) {
			
			Comment updated = null;
			try {
				updated = commentServ.updateComment(comment, commentId);
				
			} catch (Exception e ) {
				e.printStackTrace();
				resp.setStatus(400);
			}
			return updated;
		}
		
		@DeleteMapping("comments/{id}")
		public Boolean deleteComment(
				@PathVariable int id, 
				HttpServletResponse resp) {
			Boolean deleted = commentServ.deleteComment(id);
			if (deleted) {
				resp.setStatus(204);
			}
				
			return deleted;
		}
}









