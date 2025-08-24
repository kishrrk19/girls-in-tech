import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module'; // 追加
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClient, HttpClientModule } from '@angular/common/http';
import { CreateFormationSchoolComponent } from './create-formation-school/create-formation-school.component';
import { FormationSchoolDetailComponent } from './formation-school-detail/formation-school-detail.component';
import { HeaderComponent } from './header/header.component';
import { FormationSchoolComponent } from './formation-school/formation-school.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { MatCardModule } from '@angular/material/card';
import { FormationsListComponent } from './formations-list/formations-list.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CreateAccountComponent } from './create-account/create-account.component';
import { LoginComponent } from './login/login.component';
import { UpdateFormationSchoolComponent } from './update-formation-school/update-formation-school.component';
import { DeleteDialogComponent } from './dialogs/delete-dialog/delete-dialog.component';
import { MatDialogActions, MatDialogContent, MatDialogModule } from '@angular/material/dialog';
import { DeleteDialogContentComponent } from './dialogs/delete-dialog-content/delete-dialog-content.component';
import { FormationDetailComponent } from './formation-detail/formation-detail.component';
import { MatButtonModule } from '@angular/material/button';
import { FormationListHomeComponent } from './formation-list-home/formation-list-home.component';
import { RouterLink, RouterModule } from '@angular/router';
import { SearchFormationComponent } from './search-formation/search-formation.component';
import { MatIconModule } from '@angular/material/icon';
import { UpdateAndDeleteFormationComponent } from './update-and-delete-formation/update-and-delete-formation.component';
import { HomeComponent } from './home/home.component';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatRadioModule } from '@angular/material/radio';
import { AuthTokenInterceptor } from './core/interceptors/auth-token.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    CreateFormationSchoolComponent,
    FormationSchoolDetailComponent,
    HeaderComponent,
    FormationSchoolComponent,
    FormationsListComponent,
    CreateAccountComponent,
    LoginComponent,
    UpdateFormationSchoolComponent,
    DeleteDialogComponent,
    DeleteDialogContentComponent,
    FormationDetailComponent,
    FormationListHomeComponent,
    SearchFormationComponent,
    UpdateAndDeleteFormationComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatCardModule,
    NgbModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatDialogModule,
    MatDialogActions,
    MatDialogContent,
    MatButtonModule,
    RouterLink,
    MatIconModule,
    MatProgressSpinnerModule,
    MatPaginatorModule,
    MatRadioModule
  ],
  providers: [
    provideAnimationsAsync(),
    { provide: HTTP_INTERCEPTORS, useClass: AuthTokenInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
