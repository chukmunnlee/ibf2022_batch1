import { Component, Input, OnInit } from '@angular/core';
import { Deck, Hand, RemoveCard } from './models';

const PLAYERS = [ 'fred', 'barney', 'wilma', 'betty' ]

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  deck!: Deck

  players: Hand[] = []

  ngOnInit(): void {
    this.deck = new Deck()
    this.deck.shuffle()
    console.info(this.deck.dump())

    for (let n of PLAYERS) {
      this.players.push({
        name: n,
        cards: this.deck.take(5)
      })
    }

    console.info(this.players)
  }

  removeCard(event: RemoveCard) {
    console.info('>>> event: ', event)
    const p = this.players.find(v => v.name == event.name)
    p?.cards.splice(event.cardNum, 1)
  }

}
