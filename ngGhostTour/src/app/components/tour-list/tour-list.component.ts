import { Component, OnInit } from '@angular/core';
import { Tour } from 'src/app/models/tour';
import { TourService } from 'src/app/services/tour.service';
import { r3JitTypeSourceSpan } from '@angular/compiler';

@Component({
  selector: 'app-tour-list',
  templateUrl: './tour-list.component.html',
  styleUrls: ['./tour-list.component.css']
})
export class TourListComponent implements OnInit {

  tours: Tour[] = [];
  selected: Tour | null = null;
  newTour: Tour = new Tour();
  editTour: Tour | null = null;


  constructor(private TourService: TourService) { }

  ngOnInit(): void {
    this.loadTours();
  }

  loadTours(): void {
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
  reload() {
    this.TourService.index().subscribe(
    {
      next: (data) => {
        this.tours = data
      },
      error: (err) => {
        console.log('TourListComponent.reload(): error loading tours:');
        console.log(err);
      }
    }
    )
  }

  createTour(tour: Tour): void {
    this.TourService.createTour(this.newTour).subscribe(
      {
        next: (result) => {
          this.newTour = new Tour();
          this.reload();

        },
        error: (problem) => {
          console.error('PokemonHttpComponent.createPokemon(): error adding pokemons:');
          console.error(problem);
        }
      }
    );
  }
  displayTour(tour: Tour){
    this.selected = tour;
    console.log(this.selected);
  }

  setEditTour() {
    this.editTour = Object.assign({}, this.selected);
  }
  updateTour(updatedTour: Tour) {
  this.TourService.update(updatedTour).subscribe(
    {
      next: (data) => {
        this.selected = data;
        this.editTour = null;
        this.reload();
      },
      error: (err) => {
        console.error('TourListComponent.updateTour(): error updating tour:');
        console.error(err);
      }

    }
  )
  }

  updateCompleted(updatedTour: Tour) {
    this.TourService.update(updatedTour).subscribe(
     {
       next: (data) => {
         this.reload();
       },
       error: (err) => {
         console.error('TourListComponent.updateTour(): error updating tour:');
         console.error(err);
       }
     }
   );

   }

  deleteTour(id: number) {
    this.TourService.deleteTour(id).subscribe(
      {
        next: (data) => {
          this.selected = null;
          this.reload();
        },
        error: (err) => {
          console.error('TourListComponent.deleteTour(): error deleting tour:');
          console.error(err);
        }
      }
    );
  }

}
