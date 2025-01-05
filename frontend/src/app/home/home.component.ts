import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router, RouterModule, Routes} from '@angular/router';
import { UserService } from '../user.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  login: FormGroup;
  show:Boolean=false;
  message='This username is not registered!! Please register First then login'
  token:any;
  details:any;

  constructor(private formBuilder: FormBuilder, private router:Router,private userservice: UserService){}

  ngOnInit(): void {
    this.login = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  // this function is used to generate token for user
  
  Login(){
    if(this.login.invalid) {
      return;
    }
    this.details=this.login.value;
    this.userservice.token(this.details).subscribe((data:any)=>{
      this.token=data;
      this.userservice.login(data.token);
      this.userservice.logindetail(this.login.value.username);
      console.log('hii..')
      this.login.reset({});
      this.router.navigate(['/search']);
      
    },
    error=>{
      console.log(error);
      this.show=true;

    }
    ) 
  }
  Close(){
    this.show=false;
  }

}
