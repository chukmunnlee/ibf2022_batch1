export interface Card {
  suit: string
  card: number
  value: number
}

export interface RemoveCard {
  name: string
  cardNum: number
}

export interface Hand {
  name: string
  cards: Card[]
}

export const SUIT = [ "clover", "spade", "diamond", "heart" ]
export const VALUE = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 ]

export class Deck {
  private deck: Card[] = []

  constructor(count = 1) {
    for (let c = 0; c < count; c++) {
      for (let s of SUIT) {
        for (let i = 0; i < 13; i++) {
          this.deck.push({
            suit: s,
            card: i + 1,
            value: VALUE[i]
          })
        }
      }
    }
  }

  shuffle() {
    const deckSize = this.deck.length;
    for (let i = 0; i < deckSize; i++) {
      let idx = Math.floor(Math.random() * deckSize)
      const toSwap = this.deck[idx]
      this.deck[idx] = this.deck[i]
      this.deck[i] = toSwap
    }
  }

  canTake(): boolean {
    return this.deck.length > 0
  }

  take(count = 1): Card[] {
    return this.deck.splice(0, count)
  }

  dump(): Card[] {
    return this.deck
  }
}
