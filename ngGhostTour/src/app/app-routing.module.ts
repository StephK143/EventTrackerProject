import { HomeComponent } from './components/home/home.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TourListComponent } from './components/tour-list/tour-list.component';
import { NotFoundComponent } from './components/not-found/not-found.component';


const routes: Routes = [
{ path: '', pathMatch: 'full', redirectTo: 'home'},
{ path: 'home', component: HomeComponent },
{ path: 'tour-list', component: TourListComponent },
{ path: '**', component: NotFoundComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
