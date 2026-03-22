import { Injectable } from "@angular/core";
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Answer } from "../models/answer";

@Injectable({
    providedIn: 'root'
})
export class AnswerDataService {

    private baseUrl = environment.gatewayUrl;

    private readonly answersByQuestionId = `${this.baseUrl}/question/answer`;

    constructor(private http: HttpClient) { };

    getAllAnswersByQuestion(questionId: number): Observable<Answer[]> {
        return this.http.get<Answer[]>(`${this.answersByQuestionId}/${questionId}`);
    }
}