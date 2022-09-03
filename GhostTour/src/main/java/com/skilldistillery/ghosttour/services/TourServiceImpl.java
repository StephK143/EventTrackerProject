package com.skilldistillery.ghosttour.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.ghosttour.entities.Tour;
import com.skilldistillery.ghosttour.repositories.TourRepository;

@Service
public class TourServiceImpl implements TourService {

	@Autowired
	private TourRepository repo;
	
	@Override
	public List<Tour> listAllTours() {
		return repo.findAll();
	}

}
