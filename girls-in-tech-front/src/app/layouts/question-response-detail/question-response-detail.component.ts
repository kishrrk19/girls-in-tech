import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Question } from '../../models/question';
import { Answer } from '../../models/answer';
import { AnswerDataService } from '../../services/answer-data-service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-question-response-detail',
  templateUrl: './question-response-detail.component.html',
  styleUrl: './question-response-detail.component.scss'
})
export class QuestionResponseDetailComponent implements OnInit {

  schoolName: string = '';
  formationName: string = '';
  question!: Question;
  questionTitle: string = '';
  questionContent: string = '';
  firstName: string = '';
  createdAt: string = '';

  answerContent: string = '';
  answerFirstName: string = '';
  answerCreatedAt: string = '';
  answers: Answer[] = [];
  notYetAnswer: boolean = true;

  constructor(private answerDataService: AnswerDataService, private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.schoolName = params['schoolName'];
      this.formationName = params['formationName'];
    })
    console.log(this.schoolName);

    this.question = history.state.question;
    this.questionTitle = this.question.title;
    this.questionContent = this.question.content;
    this.firstName = this.question.accountFirstName;
    this.createdAt = this.question.createdAt;

    this.loadAnwsers();

  }

  private loadAnwsers() {
    console.log(this.question.id)
    this.answerDataService.getAllAnswersByQuestion(this.question.id).subscribe(res => {
      if (res.length !== 0) {
        this.answers = res;
      } else {
        this.notYetAnswer = false;
      }
    })
  }

  goBack(): void {
    this.location.back();
  }

}
