import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormationDataService } from '../services/formation-data.service';

@Component({
  selector: 'app-update-formation-school',
  templateUrl: './update-formation-school.component.html',
  styleUrl: './update-formation-school.component.scss'
})
export class UpdateFormationSchoolComponent implements OnInit{

  formationUpdateForm!: FormGroup;
  exepmleId! : number;

  constructor(private fb: FormBuilder, private http:HttpClient, private formationDataService: FormationDataService){}

  ngOnInit():void{

    this.exepmleId =12;

    this.formationDataService.getDataByFormationSchoolAssociateId(this.exepmleId).subscribe({
      next: (data) => {
        console.log(data);
        this.formationUpdateForm = this.fb.group({
          schoolName : [data.schoolName, [Validators.required, Validators.maxLength(200)]],
          formationName : [data.formationName, [Validators.required, Validators.maxLength(200)]],
          city : [data.city, [Validators.required, Validators.maxLength(50)]]
        });
        
      },
      error: (error) => console.error('error occured:', error),
      complete: () => console.log('data is retrieved')
    })

    
  }

  onSubmit(){
    if(this.formationUpdateForm.valid){
      const formData = this.formationUpdateForm.value;
      console.log(formData);
      this.http.put(`http://localhost:8080/formation/update/${this.exepmleId}`, formData).subscribe({
        next: (response) => console.log('Updated formation', response)
      ,
      error: (error) => console.error('error occured:', error),
      complete: () => console.log('data is updated')
    })

  }}
  
}
