package com.skilldistillery.ghosttour.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.ghosttour.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	
}
