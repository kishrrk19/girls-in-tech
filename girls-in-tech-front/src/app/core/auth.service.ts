import { Injectable } from "@angular/core";
import { BehaviorSubject, map } from "rxjs";

export interface AuthInfo {
    token: string;
    firstName: string;
    lastName: string;
    role: string;
}

@Injectable({ providedIn: 'root' })
export class AuthService {
    private readonly _auth$ = new BehaviorSubject<AuthInfo | null>(null); //発行元

    readonly auth$ = this._auth$.asObservable();// état actuelle de authInfo

    readonly isLoggedIn$ = this.auth$.pipe(map(v => v !== null));

    constructor() {
        const token = localStorage.getItem('token');
        if (token) {
            this._auth$.next({
                token,
                firstName: localStorage.getItem('firstName') ?? '',
                lastName: localStorage.getItem('lastName') ?? '',
                role: localStorage.getItem('role') ?? ''
            })
        }
    }

    setSession(info: AuthInfo) {
        localStorage.setItem('token', info.token);
        localStorage.setItem('firstName', info.firstName);
        localStorage.setItem('lastName', info.lastName);
        localStorage.setItem('role', info.role);

        this._auth$.next(info);
    }

    clearSession() {
        localStorage.removeItem('token');
        localStorage.removeItem('firstName');
        localStorage.removeItem('lastName');
        localStorage.removeItem('role');

        this._auth$.next(null);
    }

}
