import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-crud',
  templateUrl: './crud.component.html',
  styleUrls: ['./crud.component.css']
})
export class CrudComponent implements OnInit {

  constructor(private userservice:UserserviceService,private route:Router,private frombuilder:FormBuilder) {
    
   }
  moviedata:any;
  moviename:string='';
  genre:string='';
  selectedmovie!:any;
  

  form=this.frombuilder.group({movies:this.frombuilder.array([])});
  movies():FormArray{
     return this.form.get('movies') as FormArray;
  }
  values():FormGroup{
    return this.frombuilder.group({moviename:'',genre:''});
  }


  ngOnInit(): void {
    
    this.userservice.getdata().subscribe(data=>{
      //console.log(data);
      this.moviedata=data;
      console.log(this.moviedata);
    },
    error=>this.route.navigate(['**']));
    console.log(this.moviedata);
    

  }
  save(){
    var movie={
      moviename:this.moviename,
      genre:this.genre
    }
    this.userservice.sendmovie(movie).subscribe(data=>{
      console.log(data);
      this.route.navigate(['success']);

    }
      );
  }

  add()
  {
  this.movies().push(this.values());
  }
 
  delete(movie:any,i:any)
  {
    this.userservice.deletemovie(movie).subscribe(data=>{
      console.log(data);
      //window.location.reload();
      this.userservice.getdata().subscribe(data=>{
        //console.log(data);
        this.moviedata=data;
        console.log(this.moviedata);
      },
      error=>this.route.navigate(['**']));
    
      //this.route.navigate(['success']);
      

    })
    
  }

  edit(moviedetails:any){
    this.selectedmovie=moviedetails;

  }
  hello(moviedetails:any){
    console.log("hi");
    this.userservice.updatemovie(moviedetails).subscribe(data=>{
  console.log(data);
  console.log("in side update");
  this.route.navigate(['success']);


});
  }

//   update(){
//     console.log("update");
// // this.userservice.savetomongo(moviedetails).subscribe(data=>{
// //   console.log(data);
// //   console.log("in side update");

// // });
//   }
  

}
