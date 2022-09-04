package com.skilldistillery.ghosttour.controllers;

import java.util.List;

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

import com.skilldistillery.ghosttour.entities.Tour;
import com.skilldistillery.ghosttour.services.TourService;

@RestController
@RequestMapping("api")
public class TourController {

	@Autowired
	private TourService tourServ;

	@GetMapping("tours")
	public List<Tour> listAllTours() {
		return tourServ.listAllTours();
	}

	@PostMapping("tours")
	public Tour createTour(@RequestBody Tour tour, HttpServletResponse resp) {
		Tour created = null;
		try {
			created = tourServ.createTour(tour);
			resp.setStatus(201);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}

		return created;
	}

	@PutMapping("tours/{tourId}")
	public Tour updateTour(@RequestBody Tour tour, @PathVariable int tourId, HttpServletResponse resp) {
		Tour updated = null;
		try {
			updated = tourServ.updateTour(tour, tourId);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}
		return updated;
	}

	@DeleteMapping("tours/{id}")
	public Boolean deleteTour(@PathVariable int id, HttpServletResponse resp) {
		Boolean deleted = tourServ.delete(id);
		if (deleted) {
			resp.setStatus(204);
		} else {
			resp.setStatus(404);
		}
		return deleted;
	}
}
