import { Component, OnInit } from '@angular/core';
import { Article } from './models';
import { NewsService } from './news.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  articles: Article[] = []

  constructor(private newsSvc: NewsService) { }

  ngOnInit(): void {

    this.newsSvc.onNewArticles.subscribe(
      p => {
        p.then(data => this.articles = data)
      }
    )

  }
}
