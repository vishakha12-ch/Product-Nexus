import { Component,OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-approvereview',
  templateUrl: './approvereview.component.html',
  styleUrls: ['./approvereview.component.css']
})
export class ApprovereviewComponent implements OnInit{

  list:any;
  products:any;
  result:any;

  constructor(private userservice:UserService){}

  ngOnInit(): void {
    this.userservice.getreviews().subscribe(data =>{
      console.log(data)
      this.list=data;
    },
    error =>{
      console.log(error)
    }
    )
  }

  //this method is used to approve the review

  Approve(id:any){
    this.userservice.Approvereview(id,"approved").subscribe(data =>{
      console.log(data);
      this.result=data;
      this.products=data.product;
      alert("Approved!!");
      window.location.reload();
    },
    error =>{
      console.log(error);
      alert("something went wrong");
    }
    )

    
  }

}
