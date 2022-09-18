import { Component, OnInit } from '@angular/core';
import { Tour } from 'src/app/models/tour';
import { TourService } from 'src/app/services/tour.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  tours: Tour[] = [];

  constructor(
    private TourService: TourService
  ) { }

  ngOnInit(): void {
    this.loadTourCarousel();
  }

  loadTourCarousel(): void {
    this.TourService.index().subscribe(
      {
        next: (tours) => {
          this.tours = tours;
        },
        error: (problem) => {
          console.log('TourHttpComponent.loadTours(): error loading Tours:');
          console.log(problem);
        }
      }
    );
  }

}
