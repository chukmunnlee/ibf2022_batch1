import { NgModule } from "@angular/core";

import { MatToolbarModule } from '@angular/material/toolbar'
import { MatInputModule } from '@angular/material/input'
import { MatFormFieldModule } from '@angular/material/form-field'
import { MatButtonModule } from '@angular/material/button'
import { MatIconModule } from '@angular/material/icon'

const matModules: any[] = [
  MatToolbarModule, MatInputModule, MatFormFieldModule,
  MatButtonModule, MatIconModule
]

@NgModule({
  imports: matModules,
  exports: matModules
})
export class MaterialModule {

}
