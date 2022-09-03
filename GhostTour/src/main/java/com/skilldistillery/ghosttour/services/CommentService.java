package com.skilldistillery.ghosttour.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.ghosttour.entities.Comment;

@Service
public interface CommentService {

	List<Comment> listAllComments();
}
