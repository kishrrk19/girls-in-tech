import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormationDataService } from '../services/formation-data.service';
import {MatButtonModule} from '@angular/material/button';

@Component({
  selector: 'app-formation-detail',
  templateUrl: './formation-detail.component.html',
  styleUrl: './formation-detail.component.scss'
})
export class FormationDetailComponent implements OnInit{
  //this is the choosed one
  schoolName: string ='';
  formationName: string ='';
  city: string = '';
  haveId : number = 0;


  constructor(
    private route: ActivatedRoute,
    private formationDataService: FormationDataService,

  ){}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
      const haveIdStr = params.get('haveId');
      console.log(haveIdStr);
      if(haveIdStr){
        this.haveId = Number(haveIdStr);// convert string to number
        this.fetchDetailData(this.haveId);
      }
    })
  }

  fetchDetailData(haveId : number):void {
    this.formationDataService.getDataByFormationSchoolAssociateId(haveId).subscribe(data => {
      this.schoolName= data.schoolName;
      this.formationName= data.formationName;
      this.city = data.city;
    })
  }

  deleteData(): void {
    this.formationDataService.deleteFormation(this.haveId).subscribe(
      {
        next: () => {
          console.log('Data deleted');
        },
        error: (error) => {
          console.error('Error deleting data:', error);
        }
      }
    );
  }
}
