import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BindingComponent } from './binding/binding.component';
import { DirectivesComponent } from './directives/directives.component';
import { ReactiveFormsComponent } from './reactive-forms/reactive-forms.component';
import { ServiceComponent } from './service/service.component';

const routes: Routes = [
  { path: 'binding', component: BindingComponent },
  { path: 'directives', component: DirectivesComponent },
  { path: 'reactive-forms', component: ReactiveFormsComponent },
  { path: 'service', component: ServiceComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
