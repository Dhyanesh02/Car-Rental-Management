package com.dhyaneshcodespace.Car_Rental_Service.repository;

import com.dhyaneshcodespace.Car_Rental_Service.entity.BookACar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookACarRepository extends JpaRepository<BookACar,Long> {
}
