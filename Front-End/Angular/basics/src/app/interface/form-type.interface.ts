import { FormControl, FormGroup } from "@angular/forms";

export interface formType {
    userName: FormControl<string | null>;
    rollNumber: FormControl<string | null>;
    email: FormControl<string | null>;
    address: FormGroup<addressForm>
}

export interface addressForm {
    state: FormControl<string | null>;
    city: FormControl<string | null>;
    pinCode: FormControl<number | null>
}