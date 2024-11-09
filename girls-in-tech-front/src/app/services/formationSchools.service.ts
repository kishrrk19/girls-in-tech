import { Injectable } from "@angular/core";
import { FormationSchool } from "../models/formation_school";

@Injectable({
  providedIn: 'root'
})
export class FormationSchoolsService{
  private formationSchools: FormationSchool[] = [
    new FormationSchool(
      'IMT Atlantique',
      'Ingénieur généraliste',
      'Brest',
      ['Stéphanie', 'Delphine']
    ),
    new FormationSchool(
      'Simplon.co',
      'CDA',
      'Montreuil',
      ['Marie', 'Curie']
    )
  ];

  getFormationSchools(): FormationSchool[]{
    return [...this.formationSchools];
  }

}