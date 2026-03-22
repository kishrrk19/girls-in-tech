import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { formationData } from '../models/formation-data';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FormationDataService {

  private baseUrl = environment.gatewayUrl;

  private formationsListApiUrl = `${this.baseUrl}/formation/formations`; // バックエンドのAPI URL

  private formationByHaveIdApiUrl = `${this.baseUrl}/formation`;

  private deleteFormationUrl = `${this.baseUrl}/formation/delete`;

  private allFormationList = `${this.baseUrl}/formation/list`;

  private formationByFormationId = `${this.baseUrl}/formation`;

  private getFormationToUpdateByFormationIdUrl = `${this.baseUrl}/formation/to-update`;

  constructor(private http: HttpClient) { }

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

  getDataByFormationSchoolAssociateId(id: number): Observable<any> {
    return this.http.get(`${this.formationByHaveIdApiUrl}/${id}`);
  }

  deleteFormation(formationId: number): Observable<any> {
    return this.http.delete(`${this.deleteFormationUrl}/${formationId}`)
  }

  getFormationDetailById(formationId: number): Observable<formationData> {
    return this.http.get<formationData>(`${this.formationByFormationId}/${formationId}`)
  }

  getFormationToUpdateByFormationId(formationId: number): Observable<any> {
    return this.http.get(`${this.getFormationToUpdateByFormationIdUrl}/${formationId}`)
  }
}
