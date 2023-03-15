import { AfterViewInit, Component, ViewChild } from '@angular/core';
import {map, Observable, startWith, tap} from 'rxjs';
import {TaskComponent} from './components/task.component';
import {Todo} from './models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit {

	@ViewChild(TaskComponent)
	taskComp!: TaskComponent

	invalid_!: Observable<boolean>

  ngAfterViewInit(): void {
    this.invalid_ = this.taskComp.invalid$
	}

	addTodo() {
		const todo: Todo = this.taskComp.value
		this.taskComp.clear()
		console.info('>>> todo: ', todo)
	}

}
