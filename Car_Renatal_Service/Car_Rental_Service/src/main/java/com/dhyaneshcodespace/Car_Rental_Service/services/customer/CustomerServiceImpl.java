package com.dhyaneshcodespace.Car_Rental_Service.services.customer;

import com.dhyaneshcodespace.Car_Rental_Service.dto.BookACarDto;
import com.dhyaneshcodespace.Car_Rental_Service.dto.CarDto;
import com.dhyaneshcodespace.Car_Rental_Service.entity.BookACar;
import com.dhyaneshcodespace.Car_Rental_Service.entity.Car;
import com.dhyaneshcodespace.Car_Rental_Service.entity.User;
import com.dhyaneshcodespace.Car_Rental_Service.enums.BookCarStatus;
import com.dhyaneshcodespace.Car_Rental_Service.repository.BookACarRepository;
import com.dhyaneshcodespace.Car_Rental_Service.repository.CarRepository;
import com.dhyaneshcodespace.Car_Rental_Service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final BookACarRepository bookACarRepository;

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }

    @Override
    public boolean bookACar(BookACarDto bookACarDto) {
        Optional<Car> optionalCar = carRepository.findById(bookACarDto.getCarId());
        Optional<User> optionalUser = userRepository.findById(bookACarDto.getUserId());
        if (optionalCar.isPresent() && optionalUser.isPresent()) {
            Car existingCar = optionalCar.get();
            User user = optionalUser.get();

            BookACar bookACar = createBooking(existingCar, user, bookACarDto);
            bookACarRepository.save(bookACar);

            return true;
        }
        return false;
    }

    @Override
    public CarDto getCarById(Long carId) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        return optionalCar.map(Car::getCarDto).orElse(null);
    }

    @Override
    public List<BookACarDto> getBookingsByUserId(Long userId) {
        return bookACarRepository.findAllByUserId(userId).stream().map(BookACar::getBookACarDto).collect(Collectors.toList());
    }

    private BookACar createBooking(Car car, User user, BookACarDto bookACarDto) {
        BookACar bookACar = new BookACar();
        bookACar.setUser(user);
        bookACar.setCar(car);
        bookACar.setBookCarStatus(BookCarStatus.PENDING);

        long diffInMilliSeconds = bookACarDto.getToDate().getTime() - bookACarDto.getFromDate().getTime();
        long days = TimeUnit.MILLISECONDS.toDays(diffInMilliSeconds);
        bookACar.setDays(days);
        bookACar.setPrice(car.getPrice() * days);

        return bookACar;
    }
}
