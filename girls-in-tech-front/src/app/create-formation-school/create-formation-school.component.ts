import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-create-formation-school',
  standalone: true,
  imports: [ReactiveFormsModule, HttpClientModule],
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
      city : ['', [Validators.required, Validators.maxLength(50)]]
    });
  }

  onSubmit(){
    if(this.formationCreationForm.valid){
      const formData = this.formationCreationForm.value;

      this.http.post('http://localhost:8080/formation/create', formData).subscribe(
        response => {
          console.log('La demande est encoyé', response);
        },
        error => {
          console.error('Erreur d envoie', error);
        }
      );
    }
  }


}
