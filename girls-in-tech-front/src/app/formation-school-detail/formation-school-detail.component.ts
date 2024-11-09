import { Component, OnInit } from '@angular/core';
import { FormationSchool } from '../models/formation_school';
import { FormationSchoolComponent } from '../formation-school/formation-school.component';
import { FormationSchoolsService } from '../services/formationSchools.service';

@Component({
  selector: 'app-formation-school-detail',
  standalone: true,
  imports: [FormationSchoolComponent],
  templateUrl: './formation-school-detail.component.html',
  styleUrl: './formation-school-detail.component.scss'
})
export class FormationSchoolDetailComponent implements OnInit {
  formationsSchools!: FormationSchool[];
  formationSchoolDetail! : FormationSchool;
  title = 'girls-in-tech-front';

  constructor(private formationSchoolsService: FormationSchoolsService){
  }

  ngOnInit(): void {
    this.formationsSchools = this.formationSchoolsService.getFormationSchools();

  }
}
