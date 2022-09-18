import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Tour } from '../models/tour';

@Injectable({
  providedIn: 'root'
})
export class TourService {
  private baseUrl = 'http://localhost:8083/';
private url = this.baseUrl + 'api/tours';

  constructor(

    private http: HttpClient
  ) { }

  index(): Observable<Tour[]> {
    return this.http.get<Tour[]>(this.url + '?sorted=true').pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('TourService.index(): error retrieving tour: ' + err)
        );
      })
    );
  }
  createTour(tour: Tour): Observable<Tour> {
    return this.http.post<Tour>(this.url, tour).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('TourService.createTour(): error adding tour:' + err)
        );
      })
    );
  }

  update(tour: Tour){
    return this.http.put<Tour>(this.url + '/' + tour.id, tour).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('TourService.update(): error updating Tour: ' + err
          ));
      } )
    );
  }

  deleteTour(id: number){
    return this.http.delete<void>(this.url + '/' + id).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error(
            'TourService.deleteTour(): error deleting Tour: ' + err
          )
        );
      }
      )
    );

  }
}
