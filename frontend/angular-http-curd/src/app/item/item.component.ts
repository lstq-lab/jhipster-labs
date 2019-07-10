import { Component, OnInit } from '@angular/core';
import { ItemService } from './item.service';
import { Item, IItem } from './item.model';
import { FormGroup, FormControl } from '@angular/forms';
import { HttpResponse, HttpHeaders, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  queryitems: Item[];
  itemsPerPage: number = 20;
  links: any;
  page: any = 1;
  predicate: any;
  reverse: any;
  totalItems: number;

  //表单
  createForm;
  updateForm;
  deletedForm;
  findForm;

  constructor(protected itemService: ItemService) {
    this.createForm = new FormGroup({
      name: new FormControl(),
      price: new FormControl(),
      brand: new FormControl()
    });
    this.updateForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl(),
      price: new FormControl(),
      brand: new FormControl()
    });
    this.findForm = new FormGroup({
      id: new FormControl()
    });
    this.deletedForm = new FormGroup({
      id: new FormControl()
    });
  }

  ngOnInit() {

  }

  crate(item) {
    //调用ItemService，将表单数据中的item写入服务器中
    this.itemService.create(item).subscribe(
      savedItem => {
        console.log('new item is ', savedItem);
      },
      error => {
        console.log(error);

      }
    );
  }

  update(updateItem: IItem) {
    this.itemService.update(updateItem).subscribe(updateItem => {
      console.log(updateItem);
    });
  }


  find(value: any) {
    this.itemService.find(value.id).subscribe(
      findItem => {
        console.log('find item is ', findItem.body);
      },
      error => {
        console.log(error)
      }
    );
  }

  delete(value: any) {
    this.itemService.delete(value.id).subscribe(
      deletedItem => {
        console.log('deleted item is ', deletedItem);
      },
      error => {
        console.log(error)
      }
    );
  }

  query() {
    this.itemService
      .query()
      .subscribe(
        (res: HttpResponse<Item[]>) => this.queryitems = res.body,
        (res: HttpErrorResponse) => this.onError(res.message)
      );
  }

  protected onError(errorMessage: string) {
    console.log("Error: " + errorMessage);

  }
}
