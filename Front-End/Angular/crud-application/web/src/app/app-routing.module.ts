import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddUserComponent } from './add-user/add-user.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import { GetOneComponent } from './get-one/get-one.component';
import { MainPageComponent } from './main-page/main-page.component';

const routes: Routes = [
  // { path: '', component: MainPageComponent },
  { path: '',   redirectTo: '/employees', pathMatch: 'full' },
  { path: 'employees', component: MainPageComponent },
  { path: 'employees/create', component: AddUserComponent  },
  { path: 'employees/update/:id', component: EditUserComponent },
  { path: 'employees/get-one', component: GetOneComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
