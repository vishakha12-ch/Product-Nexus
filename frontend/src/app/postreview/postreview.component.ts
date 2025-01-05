import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router, RouterModule, Routes,ActivatedRoute} from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-postreview',
  templateUrl: './postreview.component.html',
  styleUrls: ['./postreview.component.css']
})
export class PostreviewComponent implements OnInit{

  postreview: FormGroup;
  details:any;

  constructor(private userservice: UserService, private formBuilder:FormBuilder, private route:ActivatedRoute,private router:Router){}

  ngOnInit(): void {
    this.postreview = this.formBuilder.group({
      review: ['', Validators.required],
      rating: ['', Validators.required],
      username: ['',Validators.required],
    });
  }

  // this function is used to post review
  
  Review(){
    this.details = this.postreview.value;
    this.userservice.postreview(this.route.snapshot.params['productId'], this.details ).subscribe(data =>{
      console.log(data);
      alert("Submitted successfully!!");
      this.postreview.reset({});
      this.router.navigate(['/search']);
    },
    error =>{
      console.log(error);
      alert("something went wrong!!");
    }
    )


  }

}
