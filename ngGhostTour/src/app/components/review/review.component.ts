import { Component, OnInit } from '@angular/core';
import { Review } from 'src/app/models/review';
import { Tour } from 'src/app/models/tour';
import { ReviewService } from 'src/app/services/review.service';
import { r3JitTypeSourceSpan } from '@angular/compiler';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  reviews: Review[] = [];
  selected: Review | null = null;
  newReview: Review = new Review();
  newReviewTourId = 0;
  editReview: Review | null = null;
  tours: Tour[] = [];

  constructor(private ReviewService: ReviewService) { }

  ngOnInit(): void {
    this.loadReviews();
    console.log(this.reviews);
  }
  loadReviews(): void {
    this.ReviewService.index().subscribe(
      {
        next: (reviews) => {
          this.reviews = reviews;
        },
        error: (problem) => {
          console.log('ReviewHttpComponent.loadReviews(): error loading Reviews:');
          console.log(problem);
        }
      }
    );
  }
  listReviewsByTourId(rid: number) {
    this.ReviewService.listReviewsByTourId(rid).subscribe(
      {
        next: (reviews) => {
          this.reviews = reviews;
        },
        error: (problem) => {
          console.log('ReviewHttpComponent.listReviewsByState(): error loading reviews:');
          console.log(problem);
        }
      }
    );
  }
  reload() {
    this.ReviewService.index().subscribe(
    {
      next: (data) => {
        this.reviews = data
      },
      error: (err) => {
        console.log('ReviewListComponent.reload(): error loading reviews:');
        console.log(err);
      }
    }
    )
  }

  createReview(review: Review): void {
    this.ReviewService.createReview(this.newReview).subscribe(
      {
        next: (result) => {
          this.newReview = new Review();
          this.reload();

        },
        error: (problem) => {
          console.error('ReviewHttpComponent.createReview(): error adding review:');
          console.error(problem);
        }
      }
    );
  }
  displayReview(review: Review){
    this.selected = review;
    console.log(this.selected);
  }
  setTourId(tid: number){
    this.newReviewTourId = tid;
  }

  setEditReview() {
    this.editReview = Object.assign({}, this.selected);
  }
  updateReview(updatedReview: Review) {
  this.ReviewService.update(updatedReview).subscribe(
    {
      next: (data) => {
        this.selected = data;
        this.editReview = null;
        this.reload();
      },
      error: (err) => {
        console.error('ReviewListComponent.updateReview(): error updating review:');
        console.error(err);
      }

    }
  )
  }

  updateCompleted(updatedReview: Review) {
    this.ReviewService.update(updatedReview).subscribe(
     {
       next: (data) => {
         this.reload();
       },
       error: (err) => {
         console.error('ReviewListComponent.updateReview(): error updating review:');
         console.error(err);
       }
     }
   );

   }

  deleteReview(id: number) {
    this.ReviewService.deleteReview(id).subscribe(
      {
        next: (data) => {
          this.selected = null;
          this.reload();
        },
        error: (err) => {
          console.error('ReviewListComponent.deleteReview(): error deleting review:');
          console.error(err);
        }
      }
    );
  }
}
