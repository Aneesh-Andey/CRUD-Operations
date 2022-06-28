import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  private url="http://localhost:9000/user/register";
  private otherurl="http://localhost:9000/movieuser/save";
  private loginurl="http://localhost:9000/user/login";
  private gettingdataurl="http://localhost:9000/movieuser/getdata/";
  private deleteurl="http://localhost:9000/movieuser/delete/";
  private sendmovieurl="http://localhost:9000/movieuser/senddata/";
  private updatemovieurl="http://localhost:9000/movieuser/update";
  constructor(private httpclient:HttpClient) { }

  saveuser(formdetails:any):Observable<any>{
    return this.httpclient.post(`${this.url}`,formdetails);
  }

  savetomongo(formdetails:any):Observable<any>{
    return this.httpclient.post(`${this.otherurl}`,formdetails);
  }
  loginuser(formdata:any):Observable<any>
  {
    return this.httpclient.post(`${this.loginurl}`,formdata);
  }

 result:any;
  guard(result:boolean)
  {
this.result=result;
  }
  email:any;
  retrivemail(email:any)
  {
     this.email=email;
  }
  token:any;
  rerivetoken(token:any){
this.token=token
  }

  getdata():Observable<any>
  {
   var moviedataurl= this.gettingdataurl.concat(this.email);
   console.log(moviedataurl);
   console.log("token in service"+this.token);
   var headers_object = new HttpHeaders().set("Authorization", "Bearer " + this.token);
   const httpOptions = {
    headers: headers_object
  };
     return this.httpclient.get(`${moviedataurl}`,httpOptions);
  }

  deletemovie(moviedata:any){
    var deletewithemail=this.deleteurl.concat(this.email);
    return this.httpclient.post(`${deletewithemail}`,moviedata);

  }

  sendmovie(movie:any){
    var sendmovieurlwithemail=this.sendmovieurl.concat(this.email);
    return this.httpclient.post(`${sendmovieurlwithemail}`,movie);
  }
  updatemovie(formdetails:any):Observable<any>{
    return this.httpclient.post(`${this.updatemovieurl}`,formdetails);
  }
  
}
