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

  canShare = false

  constructor(private newsSvc: NewsService) { }

  ngOnInit(): void {

    this.canShare = this.newsSvc.canShare()

    this.newsSvc.onNewArticles.subscribe(
      p => {
        this.articles$ = p
      }
    )
  }

  share(text: string) {

    if (this.newsSvc.canShare())
      this.newsSvc.share(text)
        .then(() => { alert('shared' )})
        .catch(error => { alert(`ERROR: ${JSON.stringify(error)}`)})

  }

}
