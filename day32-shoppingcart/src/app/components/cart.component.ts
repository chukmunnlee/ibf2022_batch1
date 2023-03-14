import { Component, Input, OnInit } from '@angular/core';
import {Selection} from '../models';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

	@Input()
	contents: Selection[] = []

	ngOnInit(): void {
	}

}
