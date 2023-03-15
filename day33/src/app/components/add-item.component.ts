import { Component, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { Item } from '../models';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit, OnChanges {

  form!: FormGroup

  @Output()
  onNewItem = new Subject<Item>()

  @Input()
  item: Item | null = null

  get value(): Item {
    return this.form.value as Item
  }

  get invalid(): boolean {
    return this.form.invalid
  }

  constructor(private fb: FormBuilder) { }

  ngOnChanges(changes: SimpleChanges): void {
    console.info('changes: ', changes)
    const i: Item = changes['item'].currentValue
    const itemCtrl = this.form.get('item') as FormControl
    const quantityCtrl = this.form.get('quantity') as FormControl
    itemCtrl.setValue(i.item)
    quantityCtrl.setValue(i.quantity)
  }

  ngOnInit(): void {
    this.form = this.fb.group({
      item: this.fb.control<string>('', [ Validators.required, Validators.minLength(2) ]),
      quantity: this.fb.control<number>(1, [ Validators.required, Validators.min(1) ])
    })
  }

  processForm() {
    const itemCtrl = this.form.get('item') as FormControl
    const item0 = itemCtrl.value

    const value: Item = this.form.value

    this.form.reset()

    this.onNewItem.next(value)

    console.info(`item0 = ${item0}`)
    console.info('item1 = ', value)
  }
}
