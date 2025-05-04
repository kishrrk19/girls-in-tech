import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-delete-dialog-content',
  templateUrl: './delete-dialog-content.component.html',
  styleUrl: './delete-dialog-content.component.scss'
})
export class DeleteDialogContentComponent {

  constructor(private dialogRef: MatDialogRef<DeleteDialogContentComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  closeDialog(result: boolean): void {
    this.dialogRef.close(result);
  }

}
