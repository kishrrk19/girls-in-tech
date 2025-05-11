import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateFormationSchoolComponent } from './create-formation-school/create-formation-school.component';
import { FormationSchoolDetailComponent } from './formation-school-detail/formation-school-detail.component';
import { FormationsListComponent } from './formations-list/formations-list.component'
import { CreateAccountComponent } from './create-account/create-account.component'
import { LoginComponent } from './login/login.component';
import { UpdateFormationSchoolComponent } from './update-formation-school/update-formation-school.component';
import { FormationDetailComponent } from './formation-detail/formation-detail.component';
import { FormationListHomeComponent } from './formation-list-home/formation-list-home.component';
import { SearchFormationComponent } from './search-formation/search-formation.component';
import { UpdateAndDeleteFormationComponent } from './update-and-delete-formation/update-and-delete-formation.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: 'create-formation-school', component: CreateFormationSchoolComponent },//OK
  { path: 'school-detail', component: FormationSchoolDetailComponent },//OK
  { path: 'formation-detail/:haveId', component: FormationDetailComponent },// will be decomissionned
  { path: 'formations-list', component: FormationsListComponent },//result of search
  { path: 'create-account', component: CreateAccountComponent },
  { path: 'update-formation-shool', component: UpdateFormationSchoolComponent },//OK
  { path: 'search-formations', component: SearchFormationComponent },//OK
  { path: 'login', component: LoginComponent },
  { path: 'update-delete', component: UpdateAndDeleteFormationComponent },
  { path: 'list', component: FormationListHomeComponent },//? je ne sais pas
  { path: '', component: HomeComponent }, // 初期ページ
  { path: '**', component: HomeComponent } // 不明なURLのリダイレクト
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
