import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable()
export class AuthTokenInterceptor implements HttpInterceptor {

  private authService = inject(AuthService);
  private router = inject(Router);

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (!this.shouldAddTokenUrl(req.url)) {
      return next.handle(req);
    }

    const token = localStorage.getItem('token');

    if (!token || req.headers.has('Authorization')) {
      return next.handle(req);
    }

    const authReq = req.clone({
      setHeaders: { Authorization: `Bearer ${token}` }
    });

    return next.handle(authReq)

  }

  private shouldAddTokenUrl(rawUrl: string) {

    const path = this.toPathName(rawUrl);

    const NEED_AUTH_PREFIXES = ['/formation/create', '/question/create', '/question/answer', '/formation/update', '/formation/delete', '/formation/to-update'];

    // /formation も /formation/... も拾えるように exact or prefix マッチ
    return NEED_AUTH_PREFIXES.some(prefix =>
      path === prefix || path.startsWith(prefix + '/')
    );
  }

  private toPathName(rawUrl: string) {
    try {
      return new URL(rawUrl, location.origin).pathname;
    } catch {
      const i = rawUrl.indexOf('?');
      return i >= 0 ? rawUrl.slice(0, i) : rawUrl;
    }
  }


}
