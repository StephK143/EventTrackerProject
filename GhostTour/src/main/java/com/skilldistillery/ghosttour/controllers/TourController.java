package com.skilldistillery.ghosttour.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Tour> listAllTours(){
		return tourServ.listAllTours();
	}

}
