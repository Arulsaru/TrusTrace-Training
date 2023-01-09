import { Component } from '@angular/core';

@Component({
  selector: 'app-binding',
  templateUrl: './binding.component.html',
  styleUrls: ['./binding.component.css'],
})
export class BindingComponent {
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
