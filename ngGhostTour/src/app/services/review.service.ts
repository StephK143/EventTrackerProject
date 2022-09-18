import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Review } from '../models/review';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  private baseUrl = 'http://localhost:8083/';
  private url = this.baseUrl + 'api/reviews';
  private tourUrl = this.baseUrl + 'api/tours/';

  constructor(
    private http: HttpClient
  ) { }



  index(): Observable<Review[]> {
    return this.http.get<Review[]>(this.url + '?sorted=true').pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('ReviewService.index(): error retrieving review: ' + err)
        );
      })
    );
  }
  createReview(review: Review): Observable<Review> {
    return this.http.post<Review>(this.tourUrl + review.tourId + '/reviews', review).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('ReviewService.createReview(): error adding review:' + err)
        );
      })
    );
  }

  listReviewsByTourId(rid: number): Observable<Review[]> {
    return this.http.get<Review[]>(this.url + rid).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('ReviewService.index(): error retrieving review: ' + err)
        );
      })
    );
  }

  update(review: Review){
    return this.http.put<Review>(this.url + '/' + review.id, review).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('ReviewService.update(): error updating Review: ' + err
          ));
      } )
    );
  }

  deleteReview(id: number){
    return this.http.delete<void>(this.url + '/' + id).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error(
            'ReviewService.deleteReview(): error deleting Review: ' + err
          )
        );
      }
      )
    );

  }

}
