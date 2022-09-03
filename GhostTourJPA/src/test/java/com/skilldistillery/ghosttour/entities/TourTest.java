package com.skilldistillery.ghosttour.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TourTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private Tour tour;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("GhostTourJPA");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		tour = em.find(Tour.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		tour = null;
	}
	
	@Test
	void test_Tour_basic_entity_mapping() {
		assertNotNull(tour);
		assertEquals("Stanley Hotel Tour", tour.getName());
	}

}
