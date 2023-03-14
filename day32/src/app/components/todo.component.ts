import { Component, OnDestroy, OnInit, Output } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subject, Subscription } from 'rxjs';
import { Activities } from '../models';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit, OnDestroy {

  todoForm!: FormGroup
  taskArray!: FormArray

  valueChanges$!: Subscription

  @Output()
  onNewActivity = new Subject<Activities>()

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.todoForm = this.createTodoForm()
    this.valueChanges$ = this.todoForm.valueChanges.subscribe(
      values => {
        console.info('>>> values: ', values)
      }
    )
  }

  ngOnDestroy(): void {
    this.valueChanges$.unsubscribe()
  }

  addTask() {
    const g = this.fb.group({
      description: this.fb.control<string>('', [ Validators.required ]),
      dueDate: this.fb.control<string>('', [ Validators.required ])
    })
    this.taskArray.push(g)
  }

  deleteTask(idx: number) {
    this.taskArray.removeAt(idx)
  }

  saveTodo() {
    const activities = this.todoForm.value as Activities
    this.onNewActivity.next(activities)
    this.todoForm = this.createTodoForm()
  }

  isFormInvalid(): boolean {
    return this.todoForm.invalid || this.taskArray.length <= 0
  }

  private createTodoForm(): FormGroup {
    this.taskArray = this.fb.array([], [ Validators.minLength(1) ])
    return this.fb.group({
      taskName: this.fb.control<string>('', [ Validators.required ]),
      name: this.fb.control<string>('', [ Validators.required ]),
      tasks: this.taskArray
    })
  }

}
