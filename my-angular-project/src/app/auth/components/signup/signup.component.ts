import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth/auth.service';
import {NzMessageService} from "ng-zorro-antd/message";
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {
  isSpinning:boolean = false;
  signupForm!: FormGroup;

  constructor(private fb: FormBuilder,
    private authService: AuthService,
    private message:NzMessageService,
    private router :Router){ }

  // ngOnInit(): Angular's OnInit lifecycle hook is implemented to initialize the component after Angular first displays the data-bound properties and sets the directive/component's input properties. In this method:
  // The signupForm is initialized using this.fb.group(). Each field in the form is defined along with its initial value and any associated validators.
  ngOnInit(){
    this.signupForm=this.fb.group({
      username:[null,[Validators.required]],
      email:[null,[Validators.required,Validators.email]],
      password:[null,[Validators.required]],
      checkPassword:[null,[Validators.required,this.confirmationValidation]],
    })
  }

  //Check validation of Password and COnfirm Password
  confirmationValidation=(control:FormControl):{[s:string]:boolean}=>{
    if(!control.value){
      return {require:true};
    }
    else if(control.value!==this.signupForm.controls['password'].value){
      return {confirm :true,error:true};
    }
    return{};
  };
  register(){
    console.log(this.signupForm.value);
    this.authService.register(this.signupForm.value).subscribe((res)=>{
      console.log(res);
      if (res.id!=null){
        this.message.success("Signup Successful",{nzDuration:3000});
        this.router.navigateByUrl("/login");
      }
      else{
        this.message.error("Something Went Wrong!",{nzDuration:3000});
      }
    })
  }
}

/*In this Angular component code, you're creating a signup form using reactive forms approach. Let's break down the important parts:

Imports: You're importing necessary modules and symbols from Angular core and Angular forms module.

Component Decorator: This is where you define metadata for the component. In this case:

selector: Specifies the selector that identifies this component when you use it in a template.
templateUrl and styleUrls: These point to the HTML template and CSS styles for this component.
Class Declaration: Inside the class SignupComponent, you define properties and methods related to this component.

isSpinning: This property is a boolean flag which presumably controls some loading/spinning indicator.
signupForm: This property is of type FormGroup which represents the entire form. It's created using Angular's FormBuilder service.
Constructor: Angular's dependency injection system injects the FormBuilder service into the component's constructor. This service is used to create form controls and groups.

ngOnInit(): Angular's OnInit lifecycle hook is implemented to initialize the component after Angular first displays the data-bound properties and sets the directive/component's input properties. In this method:

The signupForm is initialized using this.fb.group(). Each field in the form is defined along with its initial value and any associated validators.
register(): This method is invoked when the form is submitted. Currently, it simply logs the form values to the console. */
