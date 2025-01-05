import { Component,OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router ,ActivatedRoute} from '@angular/router';


@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  reviewlist:any;
  show:Boolean=false;
  list:any;
  Sno:any=0;

  constructor(public userservice:UserService, private router:ActivatedRoute ){}

  ngOnInit(): void {
    this.userservice.productbyId(this.router.snapshot.params['productId']).subscribe(data =>{
      this.reviewlist=data;
      this.list=data.review;
      console.log(this.list);
      if(this.list.length<=0){
        this.show=true;  
      }
    },
    error =>{
      console.log(error);
    }
    )
    
  }


}
