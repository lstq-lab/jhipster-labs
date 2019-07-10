export interface IItem {
  id?: number,
  name?: string,
  price?: number,
  brand?: string
}
export class Item implements IItem {
  constructor(
    public id?: number,
    public name?: string,
    public price?: number,
    public brand?: string
  ) { }
}
