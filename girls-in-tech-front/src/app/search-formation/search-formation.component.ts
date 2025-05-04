import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-formation',
  templateUrl: './search-formation.component.html',
  styleUrl: './search-formation.component.scss'
})
export class SearchFormationComponent implements OnInit {

  formationRechercheForm!: FormGroup;
  constructor(private fb: FormBuilder,private http: HttpClient, private router:Router){}

  ngOnInit(): void {
    this.formationRechercheForm= this.fb.group({
          schoolName : ['', Validators.maxLength(200)],
          formationName : ['', Validators.maxLength(200)],
          diplomaName : ['', Validators.maxLength(200)],
          city : ['', Validators.maxLength(50)]
        });
    
  }

  onSubmit(){
    if(this.formationRechercheForm.valid){
      const formData = this.formationRechercheForm.value;

      this.router.navigate(['/formations-list'], {queryParams: formData})
    //   this.http.post('http://localhost:8080/formation/search', formData).subscribe({
    //     next: (response)=> {
    //       console.log('Response reçu', response);
    //       this.router.navigate(['/formations-list'], {queryParams: {data : JSON.stringify(response), query : formData}})
    //     } ,
    //     error : (error) => {
    //       console.error('Erreur d envoie', error);
    //     }
    //   })
    // }else{
    //   //TODO : when search criteria is not ok
    }

  }

  getErrorMessage(controlName : string) : string{
    const control = this.formationRechercheForm.get(controlName);
    if(control?.hasError('maxlength')){
      const maxlength = control.getError('maxlength').requiredLength;
      return `Maximum ${maxlength}`;
    }
    return '';
  }

  markFieldAsTouched(controlName : string): void{
    console.log("appeled");
    const control = this.formationRechercheForm.get(controlName);
    if(control){
      console.log("appel")
      control.markAsTouched();
      control.updateValueAndValidity();
    }
  }
  // onSchoolClick(school : any){
  //   this.router.navigate([
  //     //to navigate to detail page
  //   ])
  // }

}
