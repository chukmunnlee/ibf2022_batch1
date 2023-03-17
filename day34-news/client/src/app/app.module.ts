import { NgModule } from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { NewsCriteriaComponent } from './components/news-criteria.component';
import {NewsService} from './news.service';
import { ArticleComponent } from './components/article.component';

@NgModule({
  declarations: [
    AppComponent,
    NewsCriteriaComponent,
    ArticleComponent
  ],
  imports: [
    BrowserModule, ReactiveFormsModule, HttpClientModule
  ],
  providers: [ NewsService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
