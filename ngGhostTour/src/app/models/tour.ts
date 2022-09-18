export class Tour {

  id: number;
  name: string;
  city: string;
  state: string;
  image: string;


constructor(
  id: number = 0,
  name: string = "",
  city: string = "",
  state: string = "",
  image: string = ""
) {
  this.id = id;
  this.name = name;
  this.city = city;
  this.state = state;
  this.image = image;
}

}
