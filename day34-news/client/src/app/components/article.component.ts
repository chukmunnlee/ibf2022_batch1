import { Component, Input, OnInit } from '@angular/core';
import { Article } from '../models';
import { NewsService } from '../news.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {

  articles$!: Promise<Article[]>

  @Input()
  articles: Article[] = []

  constructor(private newsSvc: NewsService) { }

  ngOnInit(): void {

    this.newsSvc.onNewArticles.subscribe(
      p => {
        this.articles$ = p
      }
    )

  }

}
