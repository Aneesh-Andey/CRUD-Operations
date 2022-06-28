import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormControlName, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  regform!:FormGroup;
   json!:any;

  constructor(formbuilder:FormBuilder,private userservice:UserserviceService,private route:Router) 
  {
    this.regform=formbuilder.group({
      name:new FormControl('',Validators.required),
      email:new FormControl('',[Validators.email,Validators.required]),
      password:new FormControl('',Validators.required)
    })
    // this.json=JSON.stringify(this.regform);
   }

  ngOnInit(): void {
  }
  errormsg:any;
  register()
  {
   if(this.regform.invalid){
this.errormsg=" Please enter valid details";
   }


   if(this.regform.valid)
   {
    
    this.userservice.savetomongo(this.regform.value).subscribe(data=>{
      console.log(data); 
      this.userservice.guard(true);
      this.userservice.retrivemail(this.regform.value.email);
       this.route.navigate(['login']);});
    // this.userservice.saveuser(this.regform.value).subscribe(data=>console.log(data));
    // this.route.navigate(['crud']);
    
   }
  }

  get all()
  {
    return this.regform.controls;
  }

}
