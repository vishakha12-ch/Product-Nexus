import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router, RouterModule, Routes} from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit  {

  register: FormGroup;
  details:any;
  show:Boolean=false;
  alert:Boolean=false;

  constructor(private userservice: UserService, private formBuilder:FormBuilder, private route:Router){}

  ngOnInit(): void {
    this.register = this.formBuilder.group({
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      username: ['',Validators.required],
      email: ['',Validators.compose([Validators.required,Validators.email])],
      password: ['', Validators.required]
    });
  }


  // this function is used to register user with the details 
  
  Register(){
    if(this.register.invalid) {
      return;
    }
    this.details=this.register.value;
    this.userservice.register(this.details).subscribe((data) =>{
      console.log(data);
      alert("Registered Successfully!!");
      this.register.reset({});
      this.route.navigate(['/home']);
    },
    error =>{
      console.log(error);
      alert("Already Registered!! Try another Username and E-mail");
      this.register.reset({});

    }
    )
  }

}

