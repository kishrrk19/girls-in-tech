import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DeleteDialogContentComponent } from '../../../dialogs/delete-dialog-content/delete-dialog-content.component';
import { FormationDataService } from '../../../services/formation-data.service';
import { formationData } from '../../../models/formation-data';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-update-and-delete-formation',
  templateUrl: './update-and-delete-formation.component.html',
  styleUrl: './update-and-delete-formation.component.scss'
})
export class UpdateAndDeleteFormationComponent implements OnInit {

  updateIdForm!: FormGroup;
  deleteIdForm!: FormGroup;

  formationData!: formationData;

  // @Input() onDelete!: () => void;

  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router,
    public dialog: MatDialog, private formationDataService: FormationDataService
  ) { }

  ngOnInit(): void {
    this.updateIdForm = this.fb.group({
      updateId: ['', [Validators.required, Validators.minLength(1)]]
    });

    this.deleteIdForm = this.fb.group({
      deleteId: ['', [Validators.required, Validators.minLength(1)]]
    });
  }

  onModify() {
    if (this.updateIdForm.valid) {
      console.log(this.updateIdForm.value);
      const inputId = this.updateIdForm.get('updateId')?.value;
      this.router.navigate(['/update-formation-shool'], { queryParams: { id: inputId } })
    } else {
      alert("ID n'est pas valide")
    }

  }

  openDialog() {
    if (this.deleteIdForm.valid) {

      const inputId = this.deleteIdForm.get('deleteId')?.value;

      this.formationDataService.getFormationDetailById(inputId).subscribe(
        {
          next: (data: formationData) => {
            this.formationData = data;
            console.log(this.formationData);
            if (this.formationData) {
              const dialogRef = this.dialog.open(DeleteDialogContentComponent, {
                data: {
                  formationId: inputId,
                  schoolName: this.formationData.schoolName,
                  formationName: this.formationData.formationName
                }
              });

              dialogRef.afterClosed().subscribe(result => {
                console.log(`Dialog result: ${result}`);
                if (result == true) {
                  this.onDelete(inputId);
                }
              })
            } else {
              alert("Aucun formation est associé à cet ID")
            }
          },
          error: (error) => {
            console.error('Error while getting data by formation ID:', error);
          }
        })


    } else {
      alert("ID n'est pas valide")
    }
  }

  onDelete(id: number) {
    this.formationDataService.deleteFormation(id).subscribe(
      {
        next: () => {
          console.log("Data deleted");
          alert("Formation est supprimé.")
        },
        error: (error) => {
          console.error('Error deleting data:', error)
          alert("Error occured during deletion, do again later")
        }
      }
    )
  }

}
