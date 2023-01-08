import { Component, EventEmitter, Input, Output } from "@angular/core";

@Component({
    selector: 'app-child',
    templateUrl: './child.component.html',
    styleUrls: ['./child.component.css']
})

export class ChildComponent {
    @Input() toChild: any;
    location: String = 'from child component';
    @Output() childEvent = new EventEmitter();

    emitEvent(): void {
        this.childEvent.emit(this.location);
    }

}