import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormationSchoolComponent } from './formation-school/formation-school.component';
import { FormationSchool } from './models/formation_school';
import { FormationSchoolDetailComponent } from './formation-school-detail/formation-school-detail.component';
import { HeaderComponent } from './header/header.component';
import { CreateFormationSchoolComponent } from './create-formation-school/create-formation-school.component';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormationSchoolDetailComponent, HeaderComponent, CreateFormationSchoolComponent, ReactiveFormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  
}
