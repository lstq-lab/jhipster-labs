import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { ItemComponent } from './item/item.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from "@angular/router";
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome'
import { ItemDetailComponent } from './item/item-detail.component';
import { ItemDeletePopupComponent } from './item/item-delete-dialog.component';


const routes: Routes = [
  { path: "item/:id/view", component: ItemDetailComponent },
  {
    path: 'item/:id/delete',
    component: ItemDeletePopupComponent,
    outlet: 'popup'
  }
];



@NgModule({
  declarations: [
    AppComponent,
    ItemComponent,
    ItemDetailComponent,
    ItemDeletePopupComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FontAwesomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
