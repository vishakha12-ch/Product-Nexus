import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router, RouterModule, Routes} from '@angular/router';
import { UserService } from '../user.service';
import { SharedService } from '../shared.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit{

  search:FormGroup;
  product:any;
  show:Boolean=false;
  detail:any;

  constructor(private formBuilder: FormBuilder, private router:Router,public userservice: UserService,public sharedservice:SharedService){}

  ngOnInit(): void {
    this.product=this.sharedservice.mydata;
    this.search = this.formBuilder.group({
      search: ['',Validators.required],
    })
    
  }

  Search(){
    this.detail=this.search.value.search;
    this.userservice.getproduct(this.detail).subscribe((data) =>{
      console.log(data);
      this.product=data;
      this.sharedservice.mydata=data;
      this.detail=this.product.review;
      console.log(this.detail);
      console.log(this.product.averageRating);
      if(this.product.length<= 0){
        this.show=true;
      }
      else{
        this.show = false;
      }

    },
    error=>{
      console.log(error);
      this.show=true;
      this.search.reset({});
    }
    )

  }
}


