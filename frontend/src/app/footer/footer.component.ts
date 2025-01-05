import { Component ,OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit{

  constructor(public userservice:UserService) {}

  users:any
  review:any;
  product:any;

  ngOnInit(): void {
  
    // to get count of all registered user

    this.userservice.alluser().subscribe(data =>{
      this.users=data;
     
    },
    error =>{
      console.log(error);
    }
    )
   
    //to get count of all product
    this.userservice.allproduct().subscribe(data =>{
      this.product=data;
    },
    error =>{
      console.log(error);
    }
    )

    // to get count of all reviews


    this.userservice.allreview().subscribe(data =>{
      this.review=data;
    },
    error =>{
      console.log(error);
    })


    
  }

}
