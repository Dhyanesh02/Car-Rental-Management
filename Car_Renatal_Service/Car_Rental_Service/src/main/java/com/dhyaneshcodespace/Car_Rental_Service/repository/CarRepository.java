package com.dhyaneshcodespace.Car_Rental_Service.repository;

import com.dhyaneshcodespace.Car_Rental_Service.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
}
