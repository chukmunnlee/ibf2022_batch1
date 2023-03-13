import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HelloComponent } from './components/hello.component';
import { CountComponent } from './components/count.component';
import { NumlistComponent } from './components/numlist.component';

@NgModule({
  declarations: [
    AppComponent,
    HelloComponent,
    CountComponent,
    NumlistComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
