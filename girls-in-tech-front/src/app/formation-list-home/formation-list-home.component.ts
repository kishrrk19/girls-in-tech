import { Component, OnInit } from '@angular/core';
import { formationData } from '../models/formation-data';
import { ActivatedRoute } from '@angular/router';
import { FormationDataService } from '../services/formation-data.service';

@Component({
  selector: 'app-formation-list-home',
  templateUrl: './formation-list-home.component.html',
  styleUrl: './formation-list-home.component.scss'
})
export class FormationListHomeComponent implements OnInit {

  formationListData: formationData[] = [];

  constructor(private route: ActivatedRoute, private formationDataService: FormationDataService){};

  ngOnInit(): void {
    this.formationDataService.getAllFormations().subscribe({
      next: (data) => {
        this.formationListData = data;
        console.log(this.formationListData);
      },
      error: (error) => console.error('error occured:', error),
      complete: () => console.log('data is retrieved')
    })
  }
}
