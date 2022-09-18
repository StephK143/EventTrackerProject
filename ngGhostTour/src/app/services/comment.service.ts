import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Comment } from '../models/comment';
import { Review } from '../models/review';
import { Tour } from '../models/tour';


@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private baseUrl = 'http://localhost:8083/';
  private url = this.baseUrl + 'api/comments';
  private reviewUrl = this.baseUrl + 'api/reviews/';

    constructor(

      private http: HttpClient
    ) { }

    index(): Observable<Comment[]> {
      return this.http.get<Comment[]>(this.url + '?sorted=true').pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(
            () => new Error('CommentService.index(): error retrieving comment: ' + err)
          );
        })
      );
    }
    createComment(comment: Comment): Observable<Comment> {
      return this.http.post<Comment>(this.reviewUrl + comment.reviewId + '/comments/', comment).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(
            () => new Error('CommentService.createComment(): error adding comment:' + err)
          );
        })
      );
    }

    listCommentsByReview(review: Review): Observable<Comment[]> {
      return this.http.get<Comment[]>(this.url + review.id).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(
            () => new Error('CommentService.index(): error retrieving comment: ' + err)
          );
        })
      );
    }

    update(comment: Comment){
      return this.http.put<Comment>(this.url + '/' + comment.id, comment).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(
            () => new Error('CommentService.update(): error updating Comment: ' + err
            ));
        } )
      );
    }

    deleteComment(id: number){
      return this.http.delete<void>(this.url + '/' + id).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(
            () => new Error(
              'CommentService.deleteComment(): error deleting Comment: ' + err
            )
          );
        }
        )
      );

    }
}
