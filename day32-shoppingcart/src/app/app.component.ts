import { Component } from '@angular/core';
import {Selection} from './models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

	contents: Selection[] = []

	addItemToCart(selection: Selection) {
    console.info('selection: ', selection)
		const item = this.contents.find(i => i.name == selection.name)
		if (!!item)
			item.quantity += selection.quantity
		else
			this.contents.push(selection)
	}
}
