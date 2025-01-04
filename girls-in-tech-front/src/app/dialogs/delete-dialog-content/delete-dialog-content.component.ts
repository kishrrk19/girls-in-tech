import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-delete-dialog-content',
  templateUrl: './delete-dialog-content.component.html',
  styleUrl: './delete-dialog-content.component.scss'
})
export class DeleteDialogContentComponent {

  constructor(private dialogRef: MatDialogRef<DeleteDialogContentComponent>){}

  closeDialog(result: boolean) : void {
    this.dialogRef.close(result);
  }

}
