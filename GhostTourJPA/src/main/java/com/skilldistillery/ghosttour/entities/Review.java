package com.skilldistillery.ghosttour.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;
	
	private String name;
	
	private String email;
	
	private String description;
	
	@Column(name="price_per_person")
	private Double pricePerPerson;
	
	private String image;
	
	@Column(name="date_created")
	private LocalDateTime dateCreated;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="tour_id")
	private Tour tour;
	
	@JsonIgnore
	@OneToMany(mappedBy="review")
	private List<Comment> comments;

	public Review() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPricePerPerson() {
		return pricePerPerson;
	}

	public void setPricePerPerson(Double pricePerPerson) {
		this.pricePerPerson = pricePerPerson;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}
	

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", title=" + title + ", name=" + name + ", email=" + email + ", description="
				+ description + ", pricePerPerson=" + pricePerPerson + ", image=" + image + ", dateCreated="
				+ dateCreated + "]";
	}
	
	

}
