import { Component, Input } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DeleteDialogContentComponent } from '../delete-dialog-content/delete-dialog-content.component';
import {MatButtonModule} from '@angular/material/button';

@Component({
  selector: 'app-delete-dialog',
  templateUrl: './delete-dialog.component.html',
  styleUrl: './delete-dialog.component.scss'
})
export class DeleteDialogComponent {
  @Input() onDelete!: () => void;

  constructor(public dialog: MatDialog){}

  openDialog(){
    const dialogRef = this.dialog.open(DeleteDialogContentComponent);

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
      if(result == true){
        this.onDelete();
      }
    });
  
  }
}
