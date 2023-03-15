import { Component, Input, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { map, Observable, startWith, tap } from 'rxjs';
import {Todo} from '../models';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

	form!: FormGroup

	@Input()
	set todo(todo: Todo) {
		this.form = this.createTodoForm(todo)
	}

	get value(): Todo {
		return this.form.value as Todo
	}

  get invalid$(): Observable<boolean> {
    return this.form.statusChanges
      .pipe(
        tap(v => {
          console.info('>> form status: ', v)
        }),
        startWith('INVALID'),
        map(v => 'INVALID' == v)
      )
  }

	constructor(private fb: FormBuilder) { }

	ngOnInit(): void {
		this.form = this.createTodoForm()
	}

	clear() {
		this.form.reset()
	}

	private createTodoForm(todo: Todo | null = null): FormGroup {
		return this.fb.group({
			description: this.fb.control<string>(
				!!todo? todo.description: '', [ Validators.required ]),
			priority: this.fb.control<string>(
				!!todo? todo.priority: '', [ Validators.required ]),
			dueDate: this.fb.control<string>(
				!!todo? todo.dueDate: '', [ Validators.required ]),
		})
	}

}
