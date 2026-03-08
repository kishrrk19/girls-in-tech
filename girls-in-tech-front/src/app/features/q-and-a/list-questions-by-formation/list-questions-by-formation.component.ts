import { Component, Input, OnInit } from '@angular/core';
import { Question } from '../../../models/question';
import { QuestionDataService } from '../../../services/question-data.service';
import { map } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-questions-by-formation',
  templateUrl: './list-questions-by-formation.component.html',
  styleUrl: './list-questions-by-formation.component.scss'
})
export class ListQuestionsByFormationComponent implements OnInit {

  @Input() formationId!: number;
  @Input() formationName!: string;
  @Input() schoolName!: string;
  questionsListData: Question[] = [];

  constructor(private questionDataService: QuestionDataService, private router: Router) { }

  ngOnInit(): void {
    if (this.formationId) {
      this.loadQuestions();
    }
  }

  private loadQuestions() {
    this.questionDataService.getAllQuestionByFormation(this.formationId).subscribe(res => {
      this.questionsListData = res;
    });
  }

  openDetail(question: Question) {
    this.router.navigate(['question-detail'], {
      queryParams: { formationName: this.formationName, schoolName: this.schoolName },
      state: {
        question
      }
    })
  }


}
