import { Component } from "@angular/core";
import { FormBuilder, FormControl, FormGroup } from "@angular/forms";

@Component({
    selector: 'app-reactive-forms',
    templateUrl: './reactive-forms.component.html',
    styleUrls: ['./reactive-forms.component.css']
})

export class ReactiveFormsComponent {
    registrationForm = new FormGroup({
        userName: new FormControl(''),
        rollNumber: new FormControl(''),
        email: new FormControl(''),
        address: new FormGroup({
            state: new FormControl(''),
            city: new FormControl(''),
            pinCode: new FormControl('')
        })
    })

    setValue(): void {
        this.registrationForm.setValue({
            userName: 'Arulmozhi',
            rollNumber: '112',
            email: 'arulmozhi.ec19@bitsathy.ac.in',
            address: {
                state: 'Tamil Nadu',
                city: 'Dharmapuri',
                pinCode: '636701'
            }
        })
    }

    patchValue(): void { // filling values partially
        this.registrationForm.patchValue({
            userName: 'Arulmozhi',
            rollNumber: '112',
            email: 'arulmozhi.ec19@bitsathy.ac.in'
        })
    }
}