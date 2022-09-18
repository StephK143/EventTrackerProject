import { Tour } from "./tour";

export class Review {

  id: number;
  title: string;
  name: string;
  email: string;
  description: string;
  pricePerPerson: number;
  image: string;
  dateCreated: string;
  tours: Tour[];
  comments: Comment[];



  constructor(
    id: number = 0,
    title: string = "",
    name: string = "",
    email: string = "",
    decription: string = "",
    pricePerPerson: number = 0,
    image: string = "",
    dateCreated: string = "",
    tours: Tour[] = [],
    comments: Comment[] = []
  ) {
    this.id = id;
    this.title = title;
    this.name = name;
    this.email = email;
    this.description = decription;
    this.pricePerPerson = pricePerPerson;
    this.image = image;
    this.dateCreated = dateCreated;
    this.tours = tours;
    this.comments = comments;
  }
}







