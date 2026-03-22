import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { map } from 'rxjs';

export const adminGuard: CanActivateFn = (route, state) => {
  const auth = inject(AuthService);
  const router = inject(Router);
  return auth.auth$.pipe(
    map(user => {
      if (!user) {
        return router.createUrlTree(['/login'])
      }
      return user.role === 'ROLE_ADMIN' ? true : router.createUrlTree([''])
    })
  )
};
