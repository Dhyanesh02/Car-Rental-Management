package com.dhyaneshcodespace.Car_Rental_Service.entity;

import com.dhyaneshcodespace.Car_Rental_Service.dto.CarDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Entity
@Data
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String color;
    private String name;
    private String type;
    private String transmission;
    private String description;
    private Long price;
    private Date year;

    @Column(columnDefinition = "longblob")
    private byte[] image;

    public CarDto getCarDto(){
        CarDto carDto = new CarDto();
        carDto.setId(id);
        carDto.setName(name);
        carDto.setBrand(brand);
        carDto.setColor(color);
        carDto.setType(type);
        carDto.setTransmission(transmission);
        carDto.setDescription(description);
        carDto.setPrice(price);
        carDto.setYear(year);
        carDto.setReturnedImage(image);
        return carDto;
    }


}
