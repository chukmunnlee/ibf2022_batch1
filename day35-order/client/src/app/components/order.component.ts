import { Component, OnInit, Output } from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Subject} from 'rxjs';
import {Order} from '../models';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

	@Output()
	onNewOrder = new Subject<Order>()

	lineItems!: FormArray;
	form!: FormGroup

	get value(): Order {
		return this.form.value as Order
	}

	constructor(private fb: FormBuilder) { }

	ngOnInit(): void {
		this.form = this.createOrderForm()
	}

	addLineItem() {
		this.lineItems.push(this.createLineItem())
	}
	removeLineItem(idx: number) {
		this.lineItems.removeAt(idx)
	}

	clear() {
		this.form = this.createOrderForm()
	}

	placeOrder() {
		const order = this.form.value as Order
		this.onNewOrder.next(order)
	}

	formInvalid(): boolean {
		return this.form.invalid || this.lineItems.controls.length <= 0
	}

	private createOrderForm(): FormGroup {
		this.lineItems = this.fb.array([])
		return this.fb.group({
			name: this.fb.control<string>('', [ Validators.required ]),
			email: this.fb.control<string>('', [ Validators.required, Validators.email ]),
			lineItems: this.lineItems
		})
	}

	private createLineItem(): FormGroup {
		return this.fb.group({
			item: this.fb.control<string>('', [ Validators.required ]),
			quantity: this.fb.control<number>(1, [ Validators.required, Validators.min(1) ])
		})
	}

}
