import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-logincomp',
  templateUrl: './logincomp.component.html',
  styleUrls: ['./logincomp.component.css']
})
export class LogincompComponent implements OnInit {

  loginform!:FormGroup;
  constructor(formbuilder:FormBuilder,private route:Router,private userservice:UserserviceService) {
    this.loginform=formbuilder.group({
      email:new FormControl('',[Validators.required,Validators.email]),
      password:new FormControl('',Validators.required)
    })
   }

  ngOnInit(): void {
     }
  //token:any;
  errormsg:any;
 

  login()
  {
    if(this.loginform.valid)
    {
     
      this.userservice.loginuser(this.loginform.value).subscribe(data=>
        {
          this.userservice.retrivemail(this.loginform.value.email);
         // console.log(this.loginform.value.email);
      
          this.userservice.guard(true);
          this.userservice.rerivetoken(data.token);
          console.log(data.message);
          if(data.message==="success")
          {
          this.route.navigate(['crud']);
          }
          console.log(data.token);
         
          
        },
        error=>{this.errormsg="Invalid ID or Password";
        this.userservice.guard(false);

      }
        );
        
      
     

    }
  }

}
