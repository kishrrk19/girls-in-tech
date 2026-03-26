import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { environment } from '../../../../environments/environment';
import { AuthInfo } from '../../../core/models/authinfo';
import { Router } from '@angular/router';
import { AuthService } from '../../../core/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent implements OnInit {

  loginForm!: FormGroup;
  private baseUrl = environment.gatewayUrl;
  nonValidInput: boolean = false;

  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router, private authService: AuthService) {

  }
  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required, Validators.email]],
      password: ['', [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(20),
        Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{4,}$'),
      ]]
    })
  }

  getErrorMessage(controlName: string): string {
    const control = this.loginForm.get(controlName);
    if (control?.hasError('required')) {
      return 'Ce champ est obligatoire.';
    }
    if (control?.hasError('minLength') || control?.hasError('maxLength') || control?.hasError('pattern') || control?.hasError('email')) {
      return `Le champ n'est pas valide.`;
    }

    return '';
  }

  onSubmit() {
    if (this.loginForm.valid) {
      const formData = this.loginForm.value;
      console.log(formData);

      this.http.post<AuthInfo>(`${this.baseUrl}/account/login`, formData).subscribe({
        next: (response) => {
          console.log('La demande est encoyé', response);

          this.authService.setSession(response);

          this.router.navigateByUrl('');

        },
        error: (error) => {
          if (error.status === 401) {
            this.nonValidInput = true;
          }
          console.error('Erreur d envoie', error);
        }
      })
    }
  }



}
