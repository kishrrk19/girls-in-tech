import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent implements OnInit {

  loginForm!: FormGroup;
  private baseUrl = environment.gatewayUrl;

  constructor(private fb: FormBuilder, private http: HttpClient) {

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

  onSubmit() {
    if (this.loginForm.valid) {
      const formData = this.loginForm.value;
      console.log(formData);

      this.http.post(`${this.baseUrl}/account/login`, formData).subscribe({
        next: (response) => {
          console.log('La demande est encoyé', response);
        },
        error: (error) => {
          console.error('Erreur d envoie', error);
        }
      })
    }
  }
}
