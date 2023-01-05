import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  // selector: '.app-root', // class
  // selector: '[app-root]', // attribute
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  name: string = 'Arulmozhi Karunagaran';
  buttonId: string = 'button-one';
  isDisabled: boolean = false;
  colorStyleText: string = 'green-color';
  color: string = 'aqua';
  showText: string = '';

  onclick(): void {
    this.showText = 'Clicked button';
  }

  getName(): string {
    return this.name;
  }

}
