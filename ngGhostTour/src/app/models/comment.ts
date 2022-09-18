import { Review } from "./review";

export class Comment {

  id: number;
  name: string;
  comment: string;
  reviewId: number;
  image: string;



  constructor(
    id: number = 0,
    name: string = "",
    comment: string = "",
    reviewId: number = 0,
    image: string = ""


  ){
    this.id = id;
    this.name = name;
    this.comment = comment;
    this.reviewId = reviewId;
    this.image = image;


  }
}
