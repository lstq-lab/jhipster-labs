import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { filter, map } from 'rxjs/operators';

import { IItem } from './item.model';
import { ItemService } from './item.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html'
})
export class ItemComponent implements OnInit, OnDestroy {
  items: IItem[];
  currentAccount: any;

  constructor(
    protected itemService: ItemService,
  ) { }

  loadAll() {
    this.itemService
      .query()
      .pipe(
        filter((res: HttpResponse<IItem[]>) => res.ok),
        map((res: HttpResponse<IItem[]>) => res.body)
      )
      .subscribe(
        (res: IItem[]) => {
          this.items = res;
        },
        (res: HttpErrorResponse) => this.onError(res.message)
      );
  }

  ngOnInit() {
    this.loadAll();

    this.registerChangeInItems();
  }

  ngOnDestroy() {
  }

  trackId(index: number, item: IItem) {
    return item.id;
  }

  registerChangeInItems() {

  }

  protected onError(errorMessage: string) {
    console.log(errorMessage);

  }
}
