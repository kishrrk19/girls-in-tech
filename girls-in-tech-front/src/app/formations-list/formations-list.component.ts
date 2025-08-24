import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormationDataService } from '../services/formation-data.service';
import { formationData } from '../models/formation-data';
import { HttpClient, HttpParams } from '@angular/common/http';
import { PageEvent } from '@angular/material/paginator';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-formations-list',
  templateUrl: './formations-list.component.html',
  styleUrl: './formations-list.component.scss'
})
export class FormationsListComponent implements OnInit {

  keys: any;
  formationsResultList: any[] = [];
  total = 0;
  pageSize = 5;
  pageIndex = 0;

  @ViewChild('topOfResult') topOfResult!: ElementRef;

  queryKeys: any[] = [];
  noResult = false;
  spin = true;

  private baseUrl = environment.gatewayUrl;

  constructor(private route: ActivatedRoute, private formationDataService: FormationDataService, private http: HttpClient, private router: Router) {
  }

  ngOnInit(): void {

    this.route.queryParams.subscribe(params => {
      this.keys = params;
      if (this.keys) {
        this.keyForDisplay(this.keys);
        this.loadFormations();
      }
    })

  }

  loadFormations() {
    const params = new HttpParams()
      .set('page', this.pageIndex.toString())
      .set('size', this.pageSize.toString())

    this.http.post<FormationResponse>(`${this.baseUrl}/formation/search`, this.keys, { params }).subscribe({
      next: (response) => {
        console.log('Response reçu', response);
        const result = response.data;
        if (result.length === 0) {
          this.noResult = true;
          this.spin = false;
        } else {
          this.formationsResultList = result;
          this.total = response.total;
          this.noResult = false;
          this.spin = false;
        }
        console.log(this.formationsResultList);
      },
      error: (error) => {
        console.error('Erreur d envoie', error);
      }
    })
  }

  keyForDisplay(key: Object) {
    const keyArrayTemp = Object.values(key);// change {} to []
    keyArrayTemp.map((key) => {
      if (key !== null && String(key).trim() !== "") {
        this.queryKeys.push(key);
      }
    })
    console.log(this.queryKeys);
  }

  onPageChange(event: PageEvent) {
    console.log(event);
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.loadFormations();
    this.topOfResult.nativeElement.scrollIntoView({ behavor: 'smooth' });
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

  openDetail(id: number) {
    this.router.navigate(['school-detail'], { queryParams: { id: id } })
  }
}

interface Formation {
  id: number;
  formationName: string;
  schoolName: string;
  diplomaName: string;
  city: string;
}

interface FormationResponse {
  data: Formation[];
  total: number;
  currentPage: number;
  pageSize: number;
}