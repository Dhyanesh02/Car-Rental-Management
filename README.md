
<h1 align="center">
  <br>
  <a href="http://www.amitmerchant.com/electron-markdownify"><img src="my-angular-project/src/assets/Black and White Car Rental Service Logo.jpg" alt="CarZillac" width="200"></a>
  <br>
  Carzillac Booking
  <br>
</h1>

<h4 align="center">A minimal ambitious Full-Stack Car Rental Application</h4>

![screenshot](https://github.com/Dhyanesh02/Car-Rental-Management/blob/d35f3fd7fd593d77af66c713c2427bc9643a7643/Car_Renatal_Service/Car_Renatal_Service/Car_Rental_Service/src/main/resources/Screenshot%202024-05-23%20211600.png)

![screenshot](https://github.com/Dhyanesh02/Car-Rental-Management/blob/d35f3fd7fd593d77af66c713c2427bc9643a7643/Car_Renatal_Service/Car_Renatal_Service/Car_Rental_Service/src/main/resources/Screenshot%202024-05-23%20211609.png)

![screenshot](https://github.com/Dhyanesh02/Car-Rental-Management/blob/74d558780bd7881a17d7293598ca507e6e05adc9/Car_Renatal_Service/Car_Renatal_Service/Car_Rental_Service/src/main/resources/Screenshot%202024-05-23%20211619.png)


# Car Rental Service

## Overview

This is a demo project for a Car Rental Service application built with Spring Boot and Angular. The backend is implemented using Spring Boot 3.2.3, and the frontend uses Angular 13.3.12.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)

## Features

- User authentication and authorization
- CRUD operations for car rentals
- Validation and error handling
- JWT-based security
- RESTful API

## Architecture

- **Backend**: Spring Boot 3.2.3
- **Frontend**: Angular 13.3.12

## Prerequisites

- **Java**: 17
- **Node.js**: 14.x or 16.x (Node 18.17.1 is currently not supported by Angular 13.3.12)
- **npm**: 10.4.0
- **MySQL**: Installed and running
- **Maven**: 3.x (for building the Spring Boot application)

## Installation

### Backend

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repository-url
   cd your-repository-folder
   ```

2. Update MySQL configuration in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   ```

3. Build the Spring Boot application:
   ```bash
   mvn clean install
   ```

### Frontend

1. Navigate to the Angular project directory:
   ```bash
   cd your-repository-folder/frontend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

## Running the Application

### Backend

1. Start the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

### Frontend

1. Start the Angular development server:
   ```bash
   ng serve
   ```
2. Open your browser and navigate to `http://localhost:4200`.

## Testing

### Backend

- Run unit tests:
  ```bash
  mvn test
  ```

### Frontend

- Run unit tests:
  ```bash
  ng test
  ```

## Technologies Used

- **Spring Boot**: 3.2.3
- **Angular**: 13.3.12
- **Java**: 17
- **MySQL**
- **Maven**
- **Node.js**
- **npm**
- **JWT** for authentication
- **Lombok** for reducing boilerplate code
- **Vaadin** for JSON handling

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a new branch (`git checkout -b feature-branch`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature-branch`)
5. Create a new Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
