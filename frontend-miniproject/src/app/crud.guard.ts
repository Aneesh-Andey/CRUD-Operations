import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserserviceService } from './userservice.service';

@Injectable({
  providedIn: 'root'
})
export class CrudGuard implements CanActivate {
  constructor(private userservice:UserserviceService){}
  canActivate() {
    return this.userservice.result;
  }
  
}
