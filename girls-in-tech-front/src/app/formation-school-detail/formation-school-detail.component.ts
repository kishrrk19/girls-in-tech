import { Component, OnInit } from '@angular/core';
import { FormationSchool } from '../models/formation_school';
import { ActivatedRoute } from '@angular/router';
import { FormationSchoolComponent } from '../formation-school/formation-school.component';
import { FormationDataService } from '../services/formation-data.service';
import { formationData } from '../models/formation-data';
import { ChangeDetectorRef } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-formation-school-detail',
  templateUrl: './formation-school-detail.component.html',
  styleUrl: './formation-school-detail.component.scss'
})
export class FormationSchoolDetailComponent implements OnInit {

  formationId! : number;
  formationsListData: formationData | undefined;
  schoolName: string ='';
  formationName: string ='';
  diplomaName: string = '';
  city: string = '';
  formationsListData$!: Observable<any>;
  constructor(private route: ActivatedRoute, private formationDataService: FormationDataService, private cdr: ChangeDetectorRef){
  }

  ngOnInit(): void {
    //クエリパラメーターを取得
    //ici faire une nouvelle requête http by id de formation pour récupérer toutes les informations de cette formation y compris description, alumni
    this.route.paramMap.subscribe(params => {
      console.log(params);
      this.formationId = +params.get('id')!;
      console.log(this.formationId);
      this.formationDataService.getFormationDetailById(this.formationId).subscribe({
        next: (data) => {this.formationsListData = data;
          console.log("new implemented",this.formationsListData);
          this.cdr.detectChanges();
        },
        error: (error) => console.error('error occured:', error),
        complete: () => console.log('data is retrieved')
      })
    }
    );

    

  }
}
