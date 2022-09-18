import { Review } from "./review";

export class Comment {

  id: number;
  name: string;
  comment: string;
  image: string;



  constructor(
    id: number = 0,
    name: string = "",
    comment: string = "",
    image: string = "",


  ){
    this.id = id;
    this.name = name;
    this.comment = comment;
    this.image = image;


  }
}
