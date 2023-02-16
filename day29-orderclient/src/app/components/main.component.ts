import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormGroup} from '@angular/forms';
import {Order} from '../models';
import {OrderService} from '../order.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

	form!: FormGroup
	lineItems!: FormArray

	constructor(private fb: FormBuilder, private orderSvc: OrderService) { }

	ngOnInit(): void {
		this.form = this.createForm()
	}

	addItem() {
		this.lineItems.push(this.createLineItem())
	}

	removeItem(idx: number) {
		this.lineItems.removeAt(idx);
	}

	processForm() {
		const order: Order = this.form.value
		console.info('order: ', order)
		this.orderSvc.placeOrder(order)
			.then(result => {
				alert(`Your order has been placed. Order id is ${result.orderId}`)
				this.form = this.createForm()
			})
			.catch(error => {
				console.error(error)
				alert(`Error ${JSON.stringify(error)}`)
			})
	}

	private createLineItem() {
		return this.fb.group({
			item: this.fb.control<string>(''),
			quantity: this.fb.control<number>(1),
		})
	}

	private createForm() {
		this.lineItems = this.fb.array([])
		return this.fb.group({
			name: this.fb.control<string>(''),
			email: this.fb.control<string>(''),
			deliveryDate: this.fb.control<string>(''),
			lineItems: this.lineItems
		})
	}

}
