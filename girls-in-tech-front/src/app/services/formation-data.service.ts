import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FormationDataService {
  
  private formationsListApiUrl = 'http://localhost:8080/formation/formations'; // バックエンドのAPI URL

  private formationByHaveIdApiUrl = 'http://localhost:8080/formation';

  private deleteFormationUrl = 'http://localhost:8080/formation/delete';

  private allFormationList = 'http://localhost:8080/formation/list';

  private formationByFormationId = 'http://localhost:8080/formation'

  constructor(private http: HttpClient) {}

  // IDに基づいてデータを取得するメソッド
  getAllFormations(): Observable<any> {
    return this.http.get(`${this.allFormationList}`)
  }
  getDataById(id: number): Observable<any> {
    return this.http.get(`${this.formationsListApiUrl}/${id}`);
  }

  getDataByFormationId(formationId: number): Observable<any> {
    return this.http.get(`${this.formationsListApiUrl}/${formationId}`);
  }

  getDataByFormationSchoolAssociateId(id: number) : Observable<any>{
    return this.http.get(`${this.formationByHaveIdApiUrl}/${id}`);
  }

  deleteFormation(haveId : number) : Observable<any> {
    return this.http.delete(`${this.deleteFormationUrl}/${haveId}`)
  }

  getFormationDetailById(formationId : number) :Observable<any>{
    return this.http.get(`${this.formationByFormationId}/${formationId}`)
  }
}
