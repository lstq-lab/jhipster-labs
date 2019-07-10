import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero';
import { HEROES } from '../hero.service';

@Component({
  selector: 'app-hero-list',
  templateUrl: './hero-list.component.html',
  styleUrls: ['./hero-list.component.css']
})
export class HeroListComponent implements OnInit {

  heros: Hero[] = new Array<Hero>();
  constructor() {
    this.heros = HEROES;
  }

  ngOnInit() {
  }

}
