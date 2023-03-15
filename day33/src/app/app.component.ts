import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Item } from './models';
import { AddItemComponent } from './components/add-item.component'
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, AfterViewInit {

  form!: FormGroup
  items!: FormArray

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.items = this.fb.array([])
    this.form = this.fb.group({
      items: this.items
    })
  }

  addToCart() {
    this.items.push(this.createItem())
  }

  createItem() {
    return this.fb.group({
      item: this.fb.control<string>(''),
      quantity: this.fb.control<number>(1)
    })
  }

  ngAfterViewInit(): void {
  }

}
