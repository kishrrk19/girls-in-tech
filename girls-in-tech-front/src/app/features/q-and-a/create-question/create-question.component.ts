import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { QuestionDataService } from '../../../services/question-data.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-create-question',
  templateUrl: './create-question.component.html',
  styleUrl: './create-question.component.scss'
})
export class CreateQuestionComponent implements OnInit {
  questionCreationForm!: FormGroup;
  formationId!: number;
  formationName: string = '';
  schoolName: string = '';

  constructor(private fb: FormBuilder, private questionService: QuestionDataService, private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.route.queryParams.subscribe(params => {
      this.formationId = params['formationId'];
      this.formationName = params['formationName'];
      this.schoolName = params['schoolName']
    })

    this.questionCreationForm = this.fb.group({
      title: ['', [Validators.required, Validators.maxLength(255)]],
      content: ['', [Validators.required, Validators.maxLength(2000)]]
    });
  }

  onSubmit() {
    if (this.questionCreationForm.valid) {
      const questionData = {
        "formationId": this.formationId,
        "title": this.questionCreationForm.get('title')?.value,
        "content": this.questionCreationForm.get('content')?.value
      }


      this.questionService.createQuestion(questionData);
    }
  }

  getErrorMessage(controlName: string): string {
    const control = this.questionCreationForm.get(controlName);
    if (control?.hasError('required')) {
      console.log('obki')
      return 'Ce champ est obligatoire.';
    }
    if (control?.hasError('maxlength')) {
      const maxlength = control.getError('maxlength').requiredLength;
      return `Maximum ${maxlength}`;
    }

    return '';
  }

}
