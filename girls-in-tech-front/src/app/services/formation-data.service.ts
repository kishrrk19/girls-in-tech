import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FormationDataService {
  
  private formationsListApiUrl = 'http://localhost:8080/formation/formations'; // バックエンドのAPI URL

  private formationByHaveIdApiUrl = 'http://localhost:8080/formation';

  constructor(private http: HttpClient) {}

  // IDに基づいてデータを取得するメソッド
  getDataById(id: number): Observable<any> {
    return this.http.get(`${this.formationsListApiUrl}/${id}`);
  }

  getDataByFormationId(formationId: number): Observable<any> {
    return this.http.get(`${this.formationsListApiUrl}/${formationId}`);
  }

  getDataByFormationSchoolAssociateId(id: number) : Observable<any>{
    return this.http.get(`${this.formationByHaveIdApiUrl}/${id}`);
  }
}
