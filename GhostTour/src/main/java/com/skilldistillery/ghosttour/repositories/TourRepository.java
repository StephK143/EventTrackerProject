package com.skilldistillery.ghosttour.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.ghosttour.entities.Tour;

public interface TourRepository extends JpaRepository<Tour, Integer> {

	
}
