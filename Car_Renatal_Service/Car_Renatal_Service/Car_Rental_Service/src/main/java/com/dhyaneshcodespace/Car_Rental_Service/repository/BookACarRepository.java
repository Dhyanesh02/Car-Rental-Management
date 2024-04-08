package com.dhyaneshcodespace.Car_Rental_Service.repository;

import com.dhyaneshcodespace.Car_Rental_Service.entity.BookACar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookACarRepository extends JpaRepository<BookACar,Long> {
    List<BookACar>findAllByUserId(Long userId);
}
