import { Component, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { Subject } from 'rxjs';
import { Item } from '../models';

@Component({
  selector: 'app-list-items',
  templateUrl: './list-items.component.html',
  styleUrls: ['./list-items.component.css']
})
export class ListItemsComponent implements OnChanges {

  @Input()
  items = [] as Item[]

  // @Input()
  // get items(): Item[] {
  //   return this._items
  // }
  // set items(i: Item[]) {
  //   this._items = i
  //   this.itemCount = 0;
  //   for (let a of this._items)
  //     this.itemCount += a.quantity
  // }
  // private _items: Item[] = []

  @Output()
  onSelection = new Subject<number>()

  itemCount = 0

  ngOnChanges(changes: SimpleChanges) {
    console.info('>>> simple changes: ', changes)
    let its: Item[] = changes['items'].currentValue
    this.itemCount = 0
    for (let i of its)
      this.itemCount += i.quantity
  }

  selected(idx: number) {
    console.info('selected: ', idx)
    this.onSelection.next(idx)
  }

}
