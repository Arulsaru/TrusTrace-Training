import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DirectivesComponent } from './directives/directives.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ParentComponent } from './parent/parent.component';
import { ChildComponent } from './child/child.component';
import { ReactiveFormsComponent } from './reactive-forms/reactive-forms.component';
import { BindingComponent } from './binding/binding.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ServiceComponent } from './service/service.component';

@NgModule({
  declarations: [
    AppComponent,
    DirectivesComponent,
    ParentComponent,
    ChildComponent,
    ReactiveFormsComponent,
    BindingComponent,
    ServiceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
