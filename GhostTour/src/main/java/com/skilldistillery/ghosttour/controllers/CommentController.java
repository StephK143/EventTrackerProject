package com.skilldistillery.ghosttour.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
