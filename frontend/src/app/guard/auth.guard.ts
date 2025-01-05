import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../user.service';
@Injectable({
  providedIn: 'root'
})

// this class is used to guard the routes from the unauthorized user

export class AuthGuard implements CanActivate {
  constructor(private userservice:UserService,
    private router: Router){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if(this.userservice.LoggedIn())
    {
      return true;
    }
    else{
      this.router.navigate(['home'])
      return false;
    }
  }
  
}

