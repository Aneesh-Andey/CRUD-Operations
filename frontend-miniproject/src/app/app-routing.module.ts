import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrudGuard } from './crud.guard';
import { CrudComponent } from './crud/crud.component';
import { ErrorComponent } from './error/error.component';
import { LogincompComponent } from './logincomp/logincomp.component';
import { RegisterComponent } from './register/register.component';
import { SuccessComponent } from './success/success.component';

const routes: Routes = [
  {path:'login',component:LogincompComponent},
  {path:'',component:RegisterComponent},
  {path:'crud',component:CrudComponent,canActivate:[CrudGuard]},
 
  {path:"success",component:SuccessComponent},
  {path:"**",pathMatch:"full",component:ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
