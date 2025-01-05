import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router, RouterModule, Routes} from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-askreview',
  templateUrl: './askreview.component.html',
  styleUrls: ['./askreview.component.css']
})
export class AskreviewComponent implements OnInit{

  askreview:FormGroup;

  constructor(private userservice:UserService, private router: Router, private formBuilder:FormBuilder){}

  ngOnInit(): void {
    this.askreview = this.formBuilder.group({
      productname: ['', Validators.required],
      username: ['',Validators.required],
      date: ['',Validators.required],
    });
  }

  // this method is for to ask review for which product that does not have review

  Askreview(){
    this.userservice.Askreviews(this.askreview.value).subscribe(data =>{
      console.log(data);
      alert("Submit Successfully");
      this.askreview.reset({});
    },
    error =>{
      console.log(error);
    }
    )
  }

}
