import { Component } from '@angular/core';
import { PicNum } from './models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'day31';
  disabled = true
  textColour = 'black'
  num = 10

  pics: PicNum[] = [
    { num: 8, text: "HUAT AH!" },
    { num: 8, text: "HUAT AH!" },
    { num: 8, text: "HUAT AH!" },
    { num: 8, text: "HUAT AH!" },
    { num: 8, text: "HUAT AH!" },
  ]

  toggleInput() {
    console.info('button clicked')
    this.disabled = !this.disabled
  }

  newValue(value: number) {
    console.info('>>> new value: ', value)
    this.num += value
  }

  cursorEntered() {
    this.textColour = "red";
  }
  cursorExit() {
    this.textColour = 'black'
  }

  newInputValue(abc: any) {
    console.info('... typed', abc)
  }
}
