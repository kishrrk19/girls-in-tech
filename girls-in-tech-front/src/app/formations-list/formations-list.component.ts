import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormationDataService } from '../services/formation-data.service';
import { formationData } from '../models/formation-data';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-formations-list',
  templateUrl: './formations-list.component.html',
  styleUrl: './formations-list.component.scss'
})
export class FormationsListComponent implements OnInit{

  formationsResultList: any[] = [];

  queryKeys: any[] = [];

  constructor(private route: ActivatedRoute,private formationDataService: FormationDataService, private http: HttpClient, private router: Router){
  }

  ngOnInit(): void {

    this.route.queryParams.subscribe(params => {
        const keys = params;
        if(keys){
          console.log(keys);

          this.http.post('http://localhost:8080/formation/search', keys).subscribe({
            next: (response)=> {
              console.log('Response reçu', response);
              this.formationsResultList = response as any[];
            
              this.keyForDisplay(keys);
          console.log(this.formationsResultList);
            } ,
            error : (error) => {
              console.error('Erreur d envoie', error);
            }
          })
          
        }
      })
    
  }

  keyForDisplay(key : Object){
    const keyArrayTemp = Object.values(key);// change {} to []
    keyArrayTemp.map((key)=> {
      if(key !== null && String(key).trim() !== ""){
        this.queryKeys.push(key);
      }
    })
    console.log(this.queryKeys);
  }
    // this.route.queryParams.subscribe(params => {
    //   const data = params['data'];
    //   const keys = params['query'];
    //   if(data){
    //     console.log(data);
    //     this.formationsResultList = JSON.parse(data);
    //     this.queryKeys = JSON.parse(keys);
    //     console.log(this.formationsResultList);
    //   }
    // })
    
  // }

  openDetail(id: number){
    this.router.navigate(['school-detail'], {queryParams:{ id: id }})
  }
}
