import { NgModule } from '@angular/core';
import { CommonModule,DatePipe  } from '@angular/common';
import { NgZorroImportsModule } from 'src/app/NgZorroImportsModule';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';

import { CustomerRoutingModule } from './customer-routing.module';
import { BookCarComponent } from './components/book-car/book-car.component';
import { MyBookingsComponent } from './components/my-bookings/my-bookings.component';
import { CustomerDashboardComponent } from './components/customer-dashboard/customer-dashboard.component';


@NgModule({
  declarations: [
    CustomerDashboardComponent,
    BookCarComponent,
    MyBookingsComponent
  ],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    NgZorroImportsModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [DatePipe],
})
export class CustomerModule { }
