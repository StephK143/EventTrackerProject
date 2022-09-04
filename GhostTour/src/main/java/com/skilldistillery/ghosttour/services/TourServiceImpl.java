package com.skilldistillery.ghosttour.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.ghosttour.entities.Tour;
import com.skilldistillery.ghosttour.repositories.TourRepository;

@Service
public class TourServiceImpl implements TourService {

	@Autowired
	private TourRepository tourRepo;

	@Override
	public List<Tour> listAllTours() {
		return tourRepo.findAll();
	}

	@Override
	public Tour createTour(Tour tour) {
		if (tour.getName() == null) {
			tour.setName("Bob Dobbs");
		}
		return tourRepo.saveAndFlush(tour);
	}

	@Override
	public Tour updateTour(Tour tour, int tourId) {
		Tour existing = findById(tour.getId());
		if (existing == null) {
			return null;
		}
		existing.setName(tour.getName());
		existing.setCity(tour.getCity());
		existing.setState(tour.getState());

		return tourRepo.saveAndFlush(existing);
	}

	private Tour findById(int id) {
		Tour t = null;
		Optional<Tour> tourOp = tourRepo.findById(id);
		if (tourOp.isPresent()) {
			t = tourOp.get();
		}
		return t;
	}

	@Override
	public Boolean delete(int id) {
		tourRepo.deleteById(id);
		return !tourRepo.existsById(id);
	}

}
