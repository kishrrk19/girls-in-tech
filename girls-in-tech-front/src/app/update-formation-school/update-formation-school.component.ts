import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormationDataService } from '../services/formation-data.service';
import { ActivatedRoute } from '@angular/router';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-update-formation-school',
  templateUrl: './update-formation-school.component.html',
  styleUrl: './update-formation-school.component.scss'
})
export class UpdateFormationSchoolComponent implements OnInit {

  formationUpdateForm!: FormGroup;
  formationId!: number;
  private baseUrl = environment.gatewayUrl;

  constructor(private fb: FormBuilder, private http: HttpClient, private formationDataService: FormationDataService, private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.route.queryParams.subscribe(params => {
      this.formationId = params['id'];
      console.log(this.formationId);

      this.formationDataService.getFormationToUpdateByFormationId(this.formationId).subscribe({
        next: (data) => {
          console.log(data);
          this.formationUpdateForm = this.fb.group({
            formationId: this.formationId,
            schoolName: [data.schoolName, [Validators.required, Validators.maxLength(200)]],
            formationName: [data.formationName, [Validators.required, Validators.maxLength(200)]],
            diplomaName: [data.diplomaName, [Validators.required, Validators.maxLength(200)]],
            city: [data.city, [Validators.required, Validators.maxLength(50)]],
            description: [data.description, Validators.maxLength(1000)],
            url: [data.url, Validators.maxLength(2083)]
          });

        },
        error: (error) => console.error('error occured:', error),
        complete: () => console.log('data is retrieved')
      })
    })

  }

  onSubmit() {
    if (this.formationUpdateForm.valid) {
      const formData = this.formationUpdateForm.value;
      console.log(formData);
      this.http.put(`${this.baseUrl}/formation/update/${this.formationId}`, formData).subscribe({
        next: (response) => console.log('Updated formation', response)
        ,
        error: (error) => console.error('error occured:', error),
        complete: () => console.log('data is updated')
      })
    }
  }

}
