import './vendor.ts'
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ExecisePlanComponent } from './execise-plan/execise-plan.component';
import { RouterModule, Routes } from '@angular/router';
import { NavbarComponent, FooterComponent, ErrorComponent } from './layout';
import { FormsModule } from '@angular/forms';



const ROUTES: Routes = [
  {
    path: '',
    component: NavbarComponent,
    outlet: 'navbar'
  },
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'execise-plan',
    component: ExecisePlanComponent
  }
];


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ExecisePlanComponent,
    NavbarComponent,
    FooterComponent,
    ErrorComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(ROUTES),
    NgbModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
