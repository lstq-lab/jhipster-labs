import { Injectable, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { Hero } from './hero';

export const HEROES: Hero[] = [
  {
    id: 1,
    name: "zhangsan"
  },
  {
    id: 2,
    name: "lisi"
  },
  {
    id: 3,
    name: "wangwu"
  }
];


@Injectable({
  providedIn: 'root'
})
export class HeroService {

  hero;

  constructor() { }

  getHero(id: number | string): Hero {
    return HEROES.find(hero => {
      hero.id === +id
    })
  }

}
