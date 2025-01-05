import { Injectable } from '@angular/core';
import { HttpClient , HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url='http://localhost:8083';

  constructor(private http: HttpClient) { }

  login(token:any){
    localStorage.setItem("token",token);
    return true;
  }

  LoggedIn()
  {
    let token=localStorage.getItem('token');
    if(token==undefined || token==null || token =="")
    {
      return false;
    }
    else{
      return true;
    }
  }
  AdminLogin()
  {
   const role=localStorage.getItem('userrole');
   if(role=='admin')
   {
    return true;
   }
   else{
    return false;
   }
  }
  
  logout()
  {
    localStorage.removeItem('token');
    localStorage.removeItem('userrole');
    localStorage.removeItem('username');
    return true;
  }

  gettoken(){
    return localStorage.getItem("token");
  }

  logindetail(data:any){
    this.currentuser(data).subscribe((details) =>{
      console.log(details);
      localStorage.setItem("username",details.username);
      localStorage.setItem("userrole",details.role);
    },
    error=>{
      console.log(error);

    }
    )
  }


  token(data:any): Observable<any>{
    return this.http.post(`${this.url}/gettoken`,data);
  }

  currentuser(username:any):Observable<any>{
    return this.http.get(`${this.url}/currentuser/${username}`);
  }

  alluser(){
    return this.http.get(`${this.url}/alluser`);
  }

  allproduct(){
    return this.http.get(`${this.url}/allproduct`);
  }

  allreview(){
    return this.http.get(`${this.url}/allreview`);
  }

  register(data:any):Observable<any>{
    return this.http.post(`${this.url}/register`,data);
  }

  getproduct(data:any): Observable<any>{
    return this.http.get(`${this.url}/getproduct/${data}`);
  }

  productbyId(id:any): Observable<any>{
    return this.http.get(`${this.url}/productbyId/${id}`);
  }

  postreview(id:any,data:any): Observable<any>{
    return this.http.post(`${this.url}/postreview/${id}`,data);
  }

  getreviews(){
    return this.http.get(`${this.url}/getreview`);
  }

  Approvereview(id:any,data:any): Observable<any>{
    return this.http.get(`${this.url}/approve/${id}/${data}`);
  }

  Askreviews(data:any): Observable<any>{
    return this.http.post(`${this.url}/Askreview`,data);
  }

  Productdetail(id:any): Observable<any>{
    return this.http.get(`${this.url}/productdetail/${id}`);
  }
}
