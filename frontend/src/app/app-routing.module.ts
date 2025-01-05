import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SearchComponent } from './search/search.component';
import { AuthGuard } from './guard/auth.guard';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ReviewComponent } from './review/review.component';
import { PostreviewComponent } from './postreview/postreview.component';
import { ApprovereviewComponent } from './approvereview/approvereview.component';
import { AskreviewComponent } from './askreview/askreview.component';


const routes: Routes = [
  {
    path:'home',
    component:HomeComponent,
    pathMatch:'full'
  },
  {
    path:'search',
    component:SearchComponent,
    pathMatch:'full',
    canActivate:[AuthGuard],
  },
  {
    path:'register',
    component:RegisterComponent,
    pathMatch:'full'
  },
  {
    path:'review/:productId',
    component: ReviewComponent,
    pathMatch:'full',
    canActivate:[AuthGuard],
  },
  {
    path:'postreview/:productId',
    component: PostreviewComponent,
    pathMatch:'full',
    canActivate:[AuthGuard],
  },
  {
    path:'approvereview',
    component: ApprovereviewComponent,
    pathMatch:'full',
    canActivate:[AuthGuard],

  },
  {
    path:'askreview',
    component:AskreviewComponent,
    pathMatch:'full',
    canActivate:[AuthGuard],
  },
 
  {
    path:'',
    component:DashboardComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
