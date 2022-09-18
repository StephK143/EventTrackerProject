import { Component, OnInit } from '@angular/core';
import { Tour } from 'src/app/models/tour';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  tour: Tour | null = null;
  constructor() { }

  ngOnInit(): void {
  }

}
