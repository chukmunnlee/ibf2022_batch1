import { Component, Input, Output } from '@angular/core';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-count',
  templateUrl: './count.component.html',
  styleUrls: ['./count.component.css']
})
export class CountComponent {

  @Input()
  startNum = 0

  @Output()
  valueChanged = new Subject<number>()

  updatePic(inc: number) {
    this.startNum += inc
    this.valueChanged.next(inc)
  }

}
