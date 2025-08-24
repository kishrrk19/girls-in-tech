import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../core/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  isNavbarCollapsed = true;

  constructor(private router: Router, public authService: AuthService) { }

  logout() {
    this.authService.clearSession();
    this.router.navigateByUrl('');
  }
}
