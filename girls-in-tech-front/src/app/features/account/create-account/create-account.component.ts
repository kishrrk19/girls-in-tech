import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { merge } from 'rxjs';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrl: './create-account.component.scss'
})
export class CreateAccountComponent implements OnInit {

  accountCreationForm!: FormGroup;
  errorMessage = '';
  private baseUrl = environment.gatewayUrl;

  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router) {
  }

  ngOnInit(): void {
    this.accountCreationForm = this.fb.group({
      username: ['', [Validators.required, Validators.email]],
      password: ['', [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(20),
        Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}$'),
      ]],
      firstName: ['', [Validators.required, Validators.maxLength(60)]],
      lastName: ['', [Validators.required, Validators.maxLength(100)]],
      roleId: [null, [Validators.required]]
    })

    const emailControl = this.accountCreationForm.get('username');

    // emailのstatusChangesとvalueChangesを監視してエラーメッセージを更新
    if (emailControl) {
      merge(emailControl?.statusChanges, emailControl?.valueChanges)
        .pipe(takeUntilDestroyed())
        .subscribe(() => this.updateErrorMessage(emailControl));
    }

  }

  updateErrorMessage(emailControl: AbstractControl | null): void {
    if (!emailControl) return;

    if (emailControl.hasError('required')) {
      this.errorMessage = 'Champ est vide, mettez votre adress mail';
    } else if (emailControl.hasError('username')) {
      this.errorMessage = "Votre adress mail n'est pas valide";
    } else {
      this.errorMessage = '';
    }
  }

  onSubmit() {
    if (this.accountCreationForm.valid) {
      const formData = this.accountCreationForm.value;
      console.log(formData);

      this.http.post(`${this.baseUrl}/account/creer-compte`, formData).subscribe({
        next: (response) => {
          console.log('La demande est encoyé', response);
          this.router.navigateByUrl('/login')
        },
        error: (error) => {
          console.error('Erreur d envoie', error);
        }
      })
    }
  }

}
