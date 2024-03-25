import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './auth/components/signup/signup.component';
import { LoginComponent } from './auth/components/login/login.component';
import { HomeComponent } from './auth/components/home/home.component';
import { AboutComponent } from './auth/components/about/about.component';
import { ServiceComponent } from './auth/components/service/service.component';
import { TestimonialsComponent } from './auth/components/testimonials/testimonials.component';
import { ContactComponent } from './auth/components/contact/contact.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'about',component:AboutComponent},
  {path:'service',component:ServiceComponent},
  {path:'testimonials',component:TestimonialsComponent},
  {path:'contact',component: ContactComponent},
  { path:"register",component:SignupComponent},
  {path:"login",component:LoginComponent},
  {path:"admin",loadChildren:()=> import("./modules/admin/admin.module").then(m=>m.AdminModule)},
  {path:"customer",loadChildren:()=> import("./modules/customer/customer.module").then(m=>m.CustomerModule)},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
