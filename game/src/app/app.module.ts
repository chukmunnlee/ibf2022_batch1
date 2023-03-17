import { Injector, NgModule, OnInit } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {GameService} from './game.service';
import {Globals} from './globals';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [ GameService ],
  bootstrap: [AppComponent]
})
export class AppModule {

	constructor(private injector: Injector) { 
		Globals.injector = this.injector
	}
}
