import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from '../../services/customer.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { StorageService } from 'src/app/auth/services/storage/storage.service';
import { NzMessageService } from 'ng-zorro-antd/message';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-book-car',
  templateUrl: './book-car.component.html',
  styleUrls: ['./book-car.component.scss']
})
export class BookCarComponent{


    constructor(private service: CustomerService,
    private activatedRoute: ActivatedRoute,
    private fb : FormBuilder,
    private message:NzMessageService,
    private router:Router,
    private datePipe: DatePipe) { }

    carId: number = this.activatedRoute.snapshot.params["id"]
    car: any;
    processedImage: any;
    validateForm!:FormGroup;
    isSpinning = false;
    dateFormat :'yyyy-MM-dd';

  ngOnInit(){
    this.validateForm = this.fb.group({
      toDate:[null,Validators.required],
      fromDate:[null,Validators.required],
    })
    this.getCarById();
  }

  getCarById(){ 
    this.service.getCarById(this.carId).subscribe((res)=> {
      console.log(res);
      this.processedImage = 'data:image/jpeg;base64,' + res.returnedImage;
      this.car = res;
    })
  }

  bookACar(data: any){
    console.log(data);
    this.isSpinning=true;
    // Convert dates to MySQL format
  let toDateFormatted = this.datePipe.transform(data.toDate, 'yyyy-MM-dd');
  let fromDateFormatted = this.datePipe.transform(data.fromDate, 'yyyy-MM-dd');

    let bookACarDto={
      toDate: toDateFormatted,
      fromDate: fromDateFormatted,
      userId:StorageService.getUserId(),
      carId: this.carId
    }
    this.service.bookACar(bookACarDto).subscribe((res) => {
  console.log(res);
  this.message.success("Booking request submitted successfully!", { nzDuration: 5000 });
  this.router.navigateByUrl("/customer/dashboard");
}, error => {
  this.message.error("Booking request failed, Try Again Later", { nzDuration: 5000 })
});
  }

}
