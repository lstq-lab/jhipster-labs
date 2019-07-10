export interface IItem {
  id?: number;
  name?: string;
  height?: number;
  weight?: number;
  gender?: string;
  age?: number;
  occupation?: string;
}

export class Item implements IItem {
  constructor(
    public id?: number,
    public name?: string,
    public height?: number,
    public weight?: number,
    public gender?: string,
    public age?: number,
    public occupation?: string
  ) { }
}
