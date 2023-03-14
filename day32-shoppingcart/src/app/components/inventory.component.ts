import { Component, OnInit, Output } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Subject} from 'rxjs';
import {INVENTORY} from '../constants';
import {Inventory, Selection} from '../models';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {

	inventories = INVENTORY

	form!: FormGroup

	@Output()
	onNewItem = new Subject<Selection>()

	constructor(private fb: FormBuilder) { }

	ngOnInit(): void {
		this.form = this.createForm()
	}

	selectItem(item: string) {
		console.info(`item: ${item}`)
		const itemCtrl = this.form.get('item') as FormControl
		const unitPriceCtrl = this.form.get('unitPrice') as FormControl
		const inv = this.findItem(item)
		if (!!inv) {
			itemCtrl.setValue(inv.name)
			unitPriceCtrl.setValue(inv.unitPrice)
		}
	}

	addToCart() {
		const selection = this.form.value as Selection
		this.onNewItem.next(selection)
		this.form.reset()
	}

	private createForm(): FormGroup {
		return this.fb.group({
			item: this.fb.control<string>('', [ Validators.required ]),
			unitPrice: this.fb.control<number>(0, [ Validators.required, Validators.min(.05) ]),
			quantity: this.fb.control<number>(0, [ Validators.required, Validators.min(1) ])
		})
	}

	private findItem(item: string): Inventory | undefined {
		return this.inventories.find(i => i.name == item)
	}
}
