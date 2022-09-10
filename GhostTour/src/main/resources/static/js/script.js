window.addEventListener('load', function() {
	console.log('Script.js loaded');
	init();
});

function init() {

	loadAllTours();

	document.addTourForm.addTour.addEventListener('click', function(e) {
		e.preventDefault();
		console.log('adding tour');
		let newTour = {
			name: addTourForm.name.value,
			city: addTourForm.city.value,
			state: addTourForm.state.value,
		};
		addNewTour(newTour);

	});
	document.updateTourForm.updateTour.addEventListener('click', function(e) {
		e.preventDefault();
		console.log('updating tour');
		let tourId = updateTourForm.tourId.value;
		let updatedTour = {

			name: updateTourForm.name.value,
			city: updateTourForm.city.value,
			state: updateTourForm.state.value,
		};

		updateTour(updatedTour, tourId);

	});
	document.updateTourForm.updateTour.addEventListener('click', function(e) {
		e.preventDefault();
		console.log('updating tour');
		let tourId = updateTourForm.tourId.value;
		let updatedTour = {

			name: updateTourForm.name.value,
			city: updateTourForm.city.value,
			state: updateTourForm.state.value,
		};

		updateTour(updatedTour, tourId);

	});
};
	
	

function updateTour(updatedTour, tourId) {
	
	let xhr = new XMLHttpRequest();
	xhr.open("PUT", `api/tours/` + tourId);

	xhr.setRequestHeader("Content-type", "application/json");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) {
				console.log("tour updated");
				console.log(updatedTour);
				console.log("ResponseText: " + xhr.responseText);
				console.log(updatedTourJson);
				
				tourDetails(updatedTour);
			} else if (xhr.status === 400) {
				displayError("Invalid Data");
			}
			else {
				console.error("Error creating film:" + xhr.status);
			}
		}
	}
	let updatedTourJson = JSON.stringify(updatedTour);
	console.log("updatedTourJSON: " + updatedTourJson);
	xhr.send(updatedTourJson);
};

function loadAllTours() {
	let xhr = new XMLHttpRequest();
	xhr.open("GET", "api/tours");
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let toursJSON = xhr.responseText;
				let tours = JSON.parse(toursJSON);
				displayTours(JSON.parse(xhr.responseText));
			} else {
				console.error("Error loading tours: " + xhr.status);
			}
		}
	}
	xhr.send();
};

function displayTours(tourList) {
	let dataDiv = document.getElementById("tourList");
	dataDiv.textContent = '';
	let h3 = document.createElement('h3');
	h3.textContent = "Tours: "
	dataDiv.appendChild(h3);
	let ul = document.createElement('ul');
	dataDiv.appendChild(ul);

	for (let tour of tourList) {
		let li = document.createElement('li');
		li.textContent = tour.name;
		ul.appendChild(li);
	}

};

function addNewTour(newTour) {
	console.log(newTour);

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/tours');

	xhr.setRequestHeader("Content-type", "application/json");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) {
				console.log("tour created");
				tourDetails(JSON.parse(xhr.responseText));
			} else if (xhr.status === 400) {
				displayError("Invalid Data");
			}
			else {
				console.error("Error creating film:" + xhr.status);
			}
		}
	};
	let newTourJson = JSON.stringify(newTour);
	xhr.send(newTourJson);
};


function tourDetails(tour) {
	let detailsDiv = document.getElementById('tourDetails');
	detailsDiv.textContent = '';

	let h1 = document.createElement('h1');
	h1.textContent = "Details for this Tour";
	detailsDiv.appendChild(h1);

	let ul = document.createElement('ul');
	detailsDiv.appendChild(ul);
	let li = document.createElement('li');
	li.textContent = 'Tour Id: ' + tour.tourId;
	ul.appendChild(li);
	li.textContent = 'Tour: ' + tour.name;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = 'City: ' + tour.city;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = 'State: ' + tour.state;
	ul.appendChild(li);

};

function displayError(msg) {
	let dataDiv = document.getElementById('tourData');
	dataDiv.textContent = msg;

};
