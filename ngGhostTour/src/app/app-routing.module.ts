import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { TourListComponent } from './components/tour-list/tour-list.component';
import { ReviewComponent } from './components/review/review.component';
import { CommentComponent } from './components/comment/comment.component';
import { NotFoundComponent } from './components/not-found/not-found.component';



const routes: Routes = [
{ path: '', pathMatch: 'full', redirectTo: 'home'},
{ path: 'home', component: HomeComponent },
{ path: 'tour-list', component: TourListComponent },
{ path: 'review', component: ReviewComponent },
{ path: 'comment', component: CommentComponent },
{ path: '**', component: NotFoundComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
