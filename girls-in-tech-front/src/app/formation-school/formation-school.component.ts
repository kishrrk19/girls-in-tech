import { Component, Input, OnInit } from '@angular/core';
import { FormationSchool } from '../models/formation_school';

@Component({
  selector: 'app-formation-school',
  standalone: true,
  imports: [],
  templateUrl: './formation-school.component.html',
  styleUrl: './formation-school.component.scss'
})
export class FormationSchoolComponent implements OnInit{
  @Input() formation_school!: FormationSchool;

  ngOnInit(): void {

  }

}
