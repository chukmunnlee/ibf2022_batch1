import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import {ReactiveFormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { MainComponent } from './components/main.component';
import {OrderService} from './order.service';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent
  ],
  imports: [
    BrowserModule, ReactiveFormsModule,
	  HttpClientModule
  ],
  providers: [ OrderService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
