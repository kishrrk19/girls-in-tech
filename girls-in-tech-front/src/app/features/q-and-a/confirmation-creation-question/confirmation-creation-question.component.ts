import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-confirmation-creation-question',
  templateUrl: './confirmation-creation-question.component.html',
  styleUrl: './confirmation-creation-question.component.scss'
})
export class ConfirmationCreationQuestionComponent implements OnInit {

  title: string = '';
  content: string = '';

  ngOnInit(): void {
    this.title = history.state.title;
    this.content = history.state.content;
  }
}
