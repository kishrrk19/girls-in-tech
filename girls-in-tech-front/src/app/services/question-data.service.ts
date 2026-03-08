import { Injectable } from "@angular/core";
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Question } from "../models/question";

@Injectable({
    providedIn: 'root'
})
export class QuestionDataService {

    private baseUrl = environment.gatewayUrl;

    private readonly allQuestionsByFormationId = `${this.baseUrl}/question/allQuestion`;

    constructor(private http: HttpClient) { }

    getAllQuestionByFormation(formationId: number): Observable<Question[]> {
        return this.http.get<Question[]>(`${this.allQuestionsByFormationId}/${formationId}`);
    }
}