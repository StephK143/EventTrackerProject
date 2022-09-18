import { Component, OnInit } from '@angular/core';
import { Comment } from 'src/app/models/comment';
import { CommentService} from 'src/app/services/comment.service';
import { r3JitTypeSourceSpan } from '@angular/compiler';
import { Review } from 'src/app/models/review';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  comments: Comment[] = [];
  selected: Comment | null = null;
  newComment: Comment = new Comment();
  editComment: Comment | null = null;

  constructor(private CommentService: CommentService) { }

  ngOnInit(): void {
    this.loadComments();
  }

  loadComments(): void {
    this.CommentService.index().subscribe(
      {
        next: (comments) => {
          this.comments = comments;
        },
        error: (problem) => {
          console.log('CommentHttpComponent.loadComments(): error loading Comments:');
          console.log(problem);
        }
      }
    );
  }
  listCommentsByReviewId(review: Review) {
    this.CommentService.listCommentsByReview(review).subscribe(
      {
        next: (comments) => {
          this.comments = comments;
        },
        error: (problem) => {
          console.log('CommentHttpComponent.listCommentsByReviewId(): error loading comments:');
          console.log(problem);
        }
      }
    );
  }
  reload() {
    this.CommentService.index().subscribe(
    {
      next: (data) => {
        this.comments = data
      },
      error: (err) => {
        console.log('CommentListComponent.reload(): error loading comments:');
        console.log(err);
      }
    }
    )
  }

  createComment(comment: Comment): void {
    this.CommentService.createComment(this.newComment).subscribe(
      {
        next: (result) => {
          this.newComment = new Comment();
          this.reload();

        },
        error: (problem) => {
          console.error('CommentHttpComponent.createComment(): error adding comment:');
          console.error(problem);
        }
      }
    );
  }
  displayComment(comment: Comment){
    this.selected = comment;
    console.log(this.selected);
  }

  setEditComment() {
    this.editComment = Object.assign({}, this.selected);
  }
  updateComment(updatedComment: Comment) {
  this.CommentService.update(updatedComment).subscribe(
    {
      next: (data) => {
        this.selected = data;
        this.editComment = null;
        this.reload();
      },
      error: (err) => {
        console.error('CommentListComponent.updateComment(): error updating comment:');
        console.error(err);
      }

    }
  )
  }

  updateCompleted(updatedComment: Comment) {
    this.CommentService.update(updatedComment).subscribe(
     {
       next: (data) => {
         this.reload();
       },
       error: (err) => {
         console.error('CommentListComponent.updateComment(): error updating comment:');
         console.error(err);
       }
     }
   );

   }

  deleteComment(id: number) {
    this.CommentService.deleteComment(id).subscribe(
      {
        next: (data) => {
          this.selected = null;
          this.reload();
        },
        error: (err) => {
          console.error('CommentListComponent.deleteComment(): error deleting comment:');
          console.error(err);
        }
      }
    );
  }
}
