import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, } from '@angular/router';
import { HeroService } from '../hero.service';
import { Hero } from '../hero';

@Component({
  selector: 'app-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css']
})
export class HeroDetailComponent implements OnInit {

  hero: Hero = {
    id: 1,
    name: "tanjie"
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private service: HeroService
  ) { }

  ngOnInit() {
    let id = this.route.snapshot.paramMap.get('id');
    console.log("id", id);
    this.hero = this.service.getHero(id);
  }

  gotoHeroes() {
    this.router.navigate(['/heroes']);
  }

}
