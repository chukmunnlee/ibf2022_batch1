export interface RSVP {
  name: string
  email: string
  age: number
  attendance: boolean
}

export interface Task {
  description: string
  dueDate: string
}

export interface Activities {
  taskName: string
  name: string
  tasks: Task[]
}
