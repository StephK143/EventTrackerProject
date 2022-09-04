package com.skilldistillery.ghosttour.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.ghosttour.entities.Tour;

@Service
public interface TourService {

	List<Tour> listAllTours();

	Tour createTour(Tour tour);

	Boolean delete(int id);

	Tour updateTour(Tour tour, int tourId);
	
	
}
