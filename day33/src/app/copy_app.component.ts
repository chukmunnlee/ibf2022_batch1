import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Item } from './models';
import { AddItemComponent } from './components/add-item.component'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, AfterViewInit {

  @ViewChild(AddItemComponent)
  addItemComp!: AddItemComponent

  @ViewChild('modifyButton')
  modifyBtnRef!: ElementRef

  items: Item[] = []

  selectedItem: Item | null = null

  ngOnInit(): void {
    console.info('>>> addItemComp: ', this.addItemComp)
  }

  ngAfterViewInit(): void {
    console.info('>>> after view init addItemComp: ', this.addItemComp)
    console.info('>>> after view init addItemComp: ', this.modifyBtnRef)
    this.modifyBtnRef.nativeElement.innerText = 'I have modified the button'
  }

  newItem(item: Item) {
    console.info('items: ', item)
    this.items = [...this.items, item ]
    //this.items.push(item)
  }

  itemSelected(idx: number) {
    this.selectedItem = this.items[idx]
  }

  modifyItem() {
    console.info('>>> modify item clicked', this.addItemComp.value)
    this.newItem(this.addItemComp.value)
  }
}
