import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-create-formation-school',
  templateUrl: './create-formation-school.component.html',
  styleUrl: './create-formation-school.component.scss'
})
export class CreateFormationSchoolComponent implements OnInit{
  formationCreationForm!: FormGroup;

  constructor(private fb: FormBuilder, private http:HttpClient){}

  ngOnInit(): void {
    this.formationCreationForm = this.fb.group({
      schoolName : ['', [Validators.required, Validators.maxLength(200)]],
      formationName : ['', [Validators.required, Validators.maxLength(200)]],
      diplomaName : ['', [Validators.required, Validators.maxLength(200)]],
      city : ['', [Validators.required, Validators.maxLength(50)]]
    });
  }

  onSubmit(){
    if(this.formationCreationForm.valid){
      const formData = this.formationCreationForm.value;

      this.http.post('http://localhost:8080/formation/create', formData,{ observe: 'response' } ).subscribe(
        response => {
          if(response.status === 202){
            alert("Votre formation est bien enregistrée!");
            this.formationCreationForm.reset();
          }
        },
        error => {
          console.error('Erreur d envoie', error);
          alert("Une erreur s'est produite. Veillez réessayer.");
        }
      );
    }
  }

  getErrorMessage(controlName : string) : string{
    const control = this.formationCreationForm.get(controlName);
    if(control?.hasError('required')){
      console.log('obki')
      return 'Ce champ est obligatoire.';
    }
    if(control?.hasError('maxlength')){
      const maxlength = control.getError('maxlength').requiredLength;
      return `Maximum ${maxlength}`;
    }

    return '';
  }

  markFieldAsTouched(controlName : string): void{
    console.log("appeled");
    const control = this.formationCreationForm.get(controlName);
    if(control){
      console.log("appel")
      control.markAsTouched();
      control.updateValueAndValidity();
    }
  }
}
