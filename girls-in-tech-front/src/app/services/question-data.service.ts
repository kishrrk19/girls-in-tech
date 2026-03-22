import { Injectable } from "@angular/core";
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Question } from "../models/question";
import { Router } from "@angular/router";

@Injectable({
    providedIn: 'root'
})
export class QuestionDataService {

    private baseUrl = environment.gatewayUrl;

    private readonly allQuestionsByFormationId = `${this.baseUrl}/question/allQuestion`;

    private readonly createQuestionUrl = `${this.baseUrl}/question/create`;

    constructor(private http: HttpClient, private router: Router) { }

    getAllQuestionByFormation(formationId: number): Observable<Question[]> {
        return this.http.get<Question[]>(`${this.allQuestionsByFormationId}/${formationId}`);
    }

    createQuestion(questionData: any) {
        this.http.post(`${this.createQuestionUrl}`, questionData).subscribe({
            next: (response) => {
                console.log('La demande est encvoyé', response);
                this.router.navigate(['confirmation-create-question'], {
                    state: questionData
                })
            },
            error: (error) => {
                console.error('Erreur d envoie', error);
            }
        })

    }
}