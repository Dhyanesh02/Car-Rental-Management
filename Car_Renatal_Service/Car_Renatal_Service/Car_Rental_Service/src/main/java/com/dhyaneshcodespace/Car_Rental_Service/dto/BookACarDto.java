package com.dhyaneshcodespace.Car_Rental_Service.dto;

import com.dhyaneshcodespace.Car_Rental_Service.enums.BookCarStatus;
import lombok.Data;

import java.util.Date;
@Data

public class BookACarDto {
    private long id;

    private Date fromDate;
    private Date toDate;
    private Long days;
    private Long price;
    private BookCarStatus bookCarStatus;
    private Long carId;
    private Long userId;
    private String username;
    private String email;

}
