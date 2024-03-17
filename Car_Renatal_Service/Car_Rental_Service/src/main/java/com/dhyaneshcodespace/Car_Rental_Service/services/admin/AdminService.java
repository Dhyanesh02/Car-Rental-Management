package com.dhyaneshcodespace.Car_Rental_Service.services.admin;

import com.dhyaneshcodespace.Car_Rental_Service.dto.CarDto;

import java.io.IOException;

public interface AdminService {
    boolean postCar(CarDto carDto) throws IOException;
}
