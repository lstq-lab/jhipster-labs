import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IItem } from './item.model';

@Component({
  selector: 'jhi-item-detail',
  templateUrl: './item-detail.component.html'
})
export class ItemDetailComponent implements OnInit {
  item: IItem;

  constructor(protected activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    console.log(this.activatedRoute.data);

    this.activatedRoute.data.subscribe(({ item }) => {
      this.item = item;
      console.log("item is ", item)
    });
  }

  previousState() {
    window.history.back();
  }
}
