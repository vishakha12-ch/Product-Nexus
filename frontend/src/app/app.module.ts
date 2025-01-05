import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ReactiveFormsModule } from '@angular/forms';
import { SearchComponent } from './search/search.component';
import { RegisterComponent } from './register/register.component'
import { AuthInterceptor } from './guard/auth.intercepter';
import { UserService } from './user.service';
import { AuthGuard } from './guard/auth.guard';
import { FooterComponent } from './footer/footer.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ReviewComponent } from './review/review.component';
import { PostreviewComponent } from './postreview/postreview.component';
import { ApprovereviewComponent } from './approvereview/approvereview.component';
import { AskreviewComponent } from './askreview/askreview.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    SearchComponent,
    RegisterComponent,
    FooterComponent,
    DashboardComponent,
    ReviewComponent,
    PostreviewComponent,
    ApprovereviewComponent,
    AskreviewComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    NgbModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule, 
    HttpClientModule

  ],
  providers: [UserService, AuthGuard, [{provide:HTTP_INTERCEPTORS, useClass:AuthInterceptor,multi:true}]],
  bootstrap: [AppComponent]
})
export class AppModule { }
