import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateFormationSchoolComponent } from './create-formation-school/create-formation-school.component';
import { FormationSchoolDetailComponent } from './formation-school-detail/formation-school-detail.component';
import { FormationsListComponent} from './formations-list/formations-list.component'
import { CreateAccountComponent} from './create-account/create-account.component'
import { LoginComponent } from './login/login.component';
import { UpdateFormationSchoolComponent } from './update-formation-school/update-formation-school.component';
import { FormationDetailComponent } from './formation-detail/formation-detail.component';

const routes: Routes = [
  { path: 'create-formation-school', component: CreateFormationSchoolComponent },
  { path: 'school-detail', component: FormationSchoolDetailComponent },//will be decomissionned
  { path: 'formation-detail/:haveId', component: FormationDetailComponent },
  { path: 'formations-list/:formationId', component: FormationsListComponent },
  { path: 'create-account', component: CreateAccountComponent },
  { path: 'update-formation-shool', component: UpdateFormationSchoolComponent },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/create-formation-school', pathMatch: 'full' }, // 初期ページ
  { path: '**', redirectTo: '/create-formation-school' } // 不明なURLのリダイレクト
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
