import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-directives',
    templateUrl: './directives.component.html',
    styleUrls: ['./directives.component.css']
})

export class DirectivesComponent implements OnInit {
    ngOnInit(): void {}
    isClicked: boolean = false;
    color: string = '';
    names: string[] = ['Arulmozhi', 'Preethi', 'Gowtham'];

    changeToClicked(): void {
        this.isClicked = !this.isClicked;
    }

    green(): void {
        this.color = 'green';
    }

    red(): void {
        this.color = 'red';
    }

    blue(): void {
        this.color = 'blue'
    }

}