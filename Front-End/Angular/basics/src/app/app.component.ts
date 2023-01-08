import { Component, ElementRef, Input } from '@angular/core';

@Component({
  selector: 'app-root',
  // selector: '.app-root', // class
  // selector: '[app-root]', // attribute
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  name: string = 'Arulmozhi Karunagaran';
  buttonId: string = 'button-one';
  isDisabled: boolean = false;
  colorStyleText: string = 'green-color';
  color: string = 'aqua';
  showText: string = '';
  twoWayBindingText: string = '';

  onclick(): void {
    this.showText = 'Clicked button';
  }

  onClick(event: MouseEvent): void {
    this.showText = `${event.type} event has occured`;
  }

  getName(): string {
    return this.name;
  }

  display(text: any): void { // any ah change pannanu
    console.log(text.value);
  }

}
