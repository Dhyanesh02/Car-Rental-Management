package com.dhyaneshcodespace.Car_Rental_Service.services.customer;

import com.dhyaneshcodespace.Car_Rental_Service.dto.BookACarDto;
import com.dhyaneshcodespace.Car_Rental_Service.dto.CarDto;

import java.util.List;

public interface CustomerService {
    List<CarDto>getAllCars();

    boolean bookACar(BookACarDto bookACarDto);

}
