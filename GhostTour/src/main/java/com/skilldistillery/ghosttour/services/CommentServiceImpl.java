package com.skilldistillery.ghosttour.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.ghosttour.entities.Comment;
import com.skilldistillery.ghosttour.repositories.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepo;

	@Override
	public List<Comment> listAllComments() {
		return commentRepo.findAll();
	}

}
