package com.skilldistillery.ghosttour.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReviewTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private Review review;
	
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
		review = em.find(Review.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		review = null;
	}
	
	@Test
	void test_Tour_basic_entity_mapping() {
		assertNotNull(review);
		assertEquals("Fred Fredette", review.getName());
		assertEquals("What a creepy hotel!", review.getTitle());
	}
	
	@Test
	void test_Review_Tour_ManyToOne_mapping() {
		assertNotNull(review);
		assertEquals("Estes Park", review.getTour().getCity());
		
	}
	@Test
	void test_Review_Comment_OneToMany_mapping() {
		assertNotNull(review);
		assertNotNull(review.getComments());
		assertTrue(review.getComments().size() > 0);
		
	}

}
