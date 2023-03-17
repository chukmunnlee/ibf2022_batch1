import { NgModule } from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import {  HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { OrderComponent } from './components/order.component';
import {OrderService} from './order.service';

@NgModule({
  declarations: [
    AppComponent,
    OrderComponent
  ],
  imports: [
    BrowserModule, ReactiveFormsModule,
	  HttpClientModule
  ],
  providers: [ OrderService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
