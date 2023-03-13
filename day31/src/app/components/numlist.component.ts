import { Component, Input } from '@angular/core';
import { PicNum } from '../models';

@Component({
  selector: 'app-numlist',
  templateUrl: './numlist.component.html',
  styleUrls: ['./numlist.component.css']
})
export class NumlistComponent {

  @Input()
  numImages: PicNum[] = []
  // [
  //   { num: 1, text: "ONE"},
  //   { num: 2, text: "TWO"},
  //   { num: 3, text: "THREE"},
  //   { num: 4, text: "FOUR"},
  //   { num: 5, text: "FIVE"},
  // ]

  //numImages = [ 1, 2, 3, 4, 5 ]

  hello(name = 'fred') {

  }

}
