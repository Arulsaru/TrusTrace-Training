import { Form, FormControl, FormGroup } from "@angular/forms";

export interface formType { 
    user: FormGroup<{
        username: FormControl<string>;
        rollNumber: FormControl<string | null>;
        email: FormControl<string | null>;
        address: FormGroup<{
            state: FormControl<string | null>;
            city: FormControl<string | null>;
            pinCode: FormControl<string | null>
        }>
    }>
}