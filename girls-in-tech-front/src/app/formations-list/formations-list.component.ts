import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormationDataService } from '../services/formation-data.service';
import { formationData } from '../models/formation-data';

@Component({
  selector: 'app-formations-list',
  templateUrl: './formations-list.component.html',
  styleUrl: './formations-list.component.scss'
})
export class FormationsListComponent implements OnInit{

  formationId! : number;
  formationsListData: formationData[] = [];

  constructor(private route: ActivatedRoute,private formationDataService: FormationDataService){
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('formationId');
    if(id !== null) {
      this.formationId= +id;
    } else {
      console.error('ID parameter is missing in the route.');
    }

    this.formationDataService.getDataByFormationId(this.formationId).subscribe({
      next: (data) => {this.formationsListData = data;
        console.log(this.formationsListData);
      },
      error: (error) => console.error('error occured:', error),
      complete: () => console.log('data is retrieved')
    })
  }
}
