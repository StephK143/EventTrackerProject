import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TourService {
  private baseUrl = 'http://localhost:8083/'; // adjust port to match server
private url = this.baseUrl + 'api/tours'; // change 'todos' to your API path

  constructor() { }
}
