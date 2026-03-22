import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateFormationSchoolComponent } from './features/formation/create-formation-school/create-formation-school.component';
import { FormationSchoolDetailComponent } from './layouts/formation-school-detail/formation-school-detail.component';
import { FormationsListComponent } from './formations-list/formations-list.component'
import { CreateAccountComponent } from './features/account/create-account/create-account.component'
import { LoginComponent } from './features/account/login/login.component';
import { UpdateFormationSchoolComponent } from './features/formation/update-formation-school/update-formation-school.component';
import { FormationListHomeComponent } from './formation-list-home/formation-list-home.component';
import { SearchFormationComponent } from './features/formation/search-formation/search-formation.component';
import { UpdateAndDeleteFormationComponent } from './features/formation/update-and-delete-formation/update-and-delete-formation.component';
import { HomeComponent } from './layouts/home/home.component';
import { authGuard } from './core/guards/auth.guard';
import { adminGuard } from './core/guards/admin.guard';
import { QuestionResponseDetailComponent } from './layouts/question-response-detail/question-response-detail.component';
import { CreateQuestionComponent } from './features/q-and-a/create-question/create-question.component';
import { ConfirmationCreationQuestionComponent } from './features/q-and-a/confirmation-creation-question/confirmation-creation-question.component';

const routes: Routes = [
  { path: 'create-formation-school', canActivate: [adminGuard], component: CreateFormationSchoolComponent },//OK
  { path: 'school-detail', component: FormationSchoolDetailComponent },//OK
  { path: 'formations-list', component: FormationsListComponent },//result of search
  { path: 'create-account', component: CreateAccountComponent },
  { path: 'update-formation-shool', canActivate: [adminGuard], component: UpdateFormationSchoolComponent },//OK
  { path: 'search-formations', component: SearchFormationComponent },//OK
  { path: 'login', component: LoginComponent },
  { path: 'update-delete', canActivate: [adminGuard], component: UpdateAndDeleteFormationComponent },
  { path: 'list', component: FormationListHomeComponent },//? je ne sais pas
  { path: 'question-detail', component: QuestionResponseDetailComponent },
  { path: 'create-question', component: CreateQuestionComponent },
  { path: 'confirmation-create-question', component: ConfirmationCreationQuestionComponent },
  { path: '', component: HomeComponent }, // 初期ページ
  { path: '**', component: HomeComponent } // 不明なURLのリダイレクト
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
