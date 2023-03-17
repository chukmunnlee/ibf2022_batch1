import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import {OrderComponent} from './components/order.component';
import {Order} from './models';
import {OrderService} from './order.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, AfterViewInit {

	@ViewChild(OrderComponent)
	orderComp!: OrderComponent

	constructor(private orderSvc: OrderService) { }

	ngOnInit(): void {
		
	}

	ngAfterViewInit(): void {
	}

	newOrder(order: Order) {
		console.info('>>> new order: ', order)
		this.orderSvc.placeOrder(order)
			.then(result => {
				alert(`Placed order. Order id is ${result.orderId}`)
				this.orderComp.clear()
			})
			.catch(error => {
				alert(`ERROR! ${JSON.stringify(error)}`)
			})
	}
}
