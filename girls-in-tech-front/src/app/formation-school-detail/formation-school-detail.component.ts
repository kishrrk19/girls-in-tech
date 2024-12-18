import { Component, OnInit } from '@angular/core';
import { FormationSchool } from '../models/formation_school';
import { ActivatedRoute } from '@angular/router';
import { FormationSchoolComponent } from '../formation-school/formation-school.component';
import { FormationDataService } from '../services/formation-data.service';

@Component({
  selector: 'app-formation-school-detail',
  templateUrl: './formation-school-detail.component.html',
  styleUrl: './formation-school-detail.component.scss'
})
export class FormationSchoolDetailComponent implements OnInit {

  schoolName: string ='';
  formationName: string ='';
  city: string = '';
  constructor(private route: ActivatedRoute){
  }

  ngOnInit(): void {
    //クエリパラメーターを取得
    this.route.queryParams.subscribe(params => {
      this.schoolName = params['school'] || '';
      this.formationName = params['formation'] || '';
      this.city = params['city'] || '';
}
    );

  }
}
