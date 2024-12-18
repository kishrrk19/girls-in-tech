import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-formation',
  templateUrl: './search-formation.component.html',
  styleUrl: './search-formation.component.scss'
})
export class SearchFormationComponent {
  searchQuery: string ='';
  results:any []= [];

  constructor(private router: Router){}

  onSearch(){

  }

  onSchoolClick(school : any){
    this.router.navigate([
      //to navigate to detail page
    ])
  }

}
