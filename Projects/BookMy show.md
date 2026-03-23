* **Full Stack Project (React + Node.js + MySQL/MongoDB)**

---

# BookMyShow

## Movie Ticket Booking System

### Software Requirement & Design Document

---

# 1. Project Overview

**BookMyShow** is a full-stack web application that enables users to browse movies, view show timings, select seats, and book tickets online.

The system includes two main roles:

1. **Customers**
2. **Theatre Administrators**

The application is built using a **modern full-stack architecture**:

Frontend: **React.js**
Backend: **Node.js (Express.js)**
Database: **MySQL / MongoDB**

The platform is designed to simulate a simplified version of platforms such as **BookMyShow** while demonstrating real-world software development practices such as:

* REST API architecture
* Role-based authentication
* Modular backend design
* Responsive UI
* Scalable system architecture

---

# 2. Technology Stack

## Frontend

| Technology              | Purpose          |
| ----------------------- | ---------------- |
| React.js                | UI Development   |
| React Router            | Navigation       |
| Axios                   | API calls        |
| Material UI / Bootstrap | UI components    |
| Redux / Context API     | State management |

---

## Backend

| Technology | Purpose             |
| ---------- | ------------------- |
| Node.js    | Server runtime      |
| Express.js | REST API framework  |
| JWT        | Authentication      |
| bcrypt     | Password encryption |
| multer     | Image uploads       |
| Nodemailer | Email notifications |

---

## Database

Option 1: **MySQL (Relational Database)**
Option 2: **MongoDB (NoSQL Database)**

---

# 3. System Architecture

```
                +---------------------+
                |      React UI       |
                |  (Frontend Layer)   |
                +---------------------+
                         |
                         | REST APIs
                         ↓
                +---------------------+
                |   Node.js Backend   |
                |     Express API     |
                +---------------------+
                         |
                         ↓
                +---------------------+
                |       Database      |
                |  MySQL / MongoDB    |
                +---------------------+
```

---

# 4. Application Modules

The system consists of the following modules:

1. Authentication Module
2. Movie Management Module
3. Theatre & Screen Management Module
4. Show Management Module
5. Booking Module
6. Notification Module
7. Reporting Module

---

# 5. User Roles

## Customer

Customers can:

* Register account
* Login
* Browse movies
* Search movies
* View show timings
* Select seats
* Book tickets
* Cancel bookings
* View booking history
* Receive notifications

---

## Theatre Administrator

Admin can:

* Add/Edit/Delete movies
* Manage theatres
* Manage screens
* Create shows
* Configure pricing
* Monitor bookings
* Generate reports

---

# 6. UI Design (React)

## Customer Interface

### Home Page

Displays:

* Current movies
* Upcoming movies
* Search bar
* Filters

Components:

```
Navbar
MovieList
MovieCard
Footer
```

---

### Movie Details Page

Displays:

* Movie poster
* Synopsis
* Cast
* Rating
* Duration
* Available theatres

Component structure:

```
MovieDetails
ShowList
BookTicketButton
```

---

### Show Selection Page

Displays:

* Theatre list
* Show timings
* Ticket price

Component:

```
ShowSelection
```

---

### Seat Selection Page

Displays seat layout:

```
A1 A2 A3 A4 A5
B1 B2 B3 B4 B5
C1 C2 C3 C4 C5
```

Seat states:

* Available
* Selected
* Booked

Component:

```
SeatSelector
```

---

### Booking Summary Page

Shows:

* Selected seats
* Ticket price
* Total amount
* Confirm booking

Component:

```
BookingSummary
```

---

### User Dashboard

Features:

* Booking history
* Cancel ticket
* Profile settings

Components:

```
UserDashboard
BookingHistory
ProfileSettings
```

---

# 7. Admin UI (React)

Admin Dashboard includes:

### Admin Panel

Features:

* Manage movies
* Manage theatres
* Manage shows
* View bookings
* Reports

Components:

```
AdminDashboard
MovieManagement
TheatreManagement
ShowManagement
BookingReport
```

---

# 8. Backend API Design (Node.js)

Base URL

```
/api
```

---

## Authentication APIs

| Method | API                   | Description     |
| ------ | --------------------- | --------------- |
| POST   | /auth/register        | Register user   |
| POST   | /auth/login           | Login           |
| POST   | /auth/change-password | Change password |

---

## Movie APIs

| Method | API         | Description       |
| ------ | ----------- | ----------------- |
| GET    | /movies     | Get all movies    |
| GET    | /movies/:id | Get movie details |
| POST   | /movies     | Add movie         |
| PUT    | /movies/:id | Update movie      |
| DELETE | /movies/:id | Delete movie      |

---

## Theatre APIs

| Method | API           | Description    |
| ------ | ------------- | -------------- |
| POST   | /theatres     | Add theatre    |
| GET    | /theatres     | List theatres  |
| PUT    | /theatres/:id | Update theatre |
| DELETE | /theatres/:id | Delete theatre |

---

## Show APIs

| Method | API              | Description       |
| ------ | ---------------- | ----------------- |
| POST   | /shows           | Create show       |
| GET    | /shows           | Get shows         |
| GET    | /shows/:id/seats | Seat availability |

---

## Booking APIs

| Method | API            | Description    |
| ------ | -------------- | -------------- |
| POST   | /bookings      | Book ticket    |
| GET    | /bookings/user | User bookings  |
| DELETE | /bookings/:id  | Cancel booking |

---

# 9. Database Design (MySQL)

## Users Table

```
users
------
user_id PK
name
email
password
role
status
created_at
```

---

## Movies Table

```
movies
------
movie_id PK
title
genre
language
duration
rating
description
release_date
```

---

## Theatres Table

```
theatres
---------
theatre_id PK
name
location
city
```

---

## Screens Table

```
screens
--------
screen_id PK
theatre_id FK
screen_name
total_seats
```

---

## Seats Table

```
seats
------
seat_id PK
screen_id FK
seat_number
seat_type
```

---

## Shows Table

```
shows
------
show_id PK
movie_id FK
screen_id FK
show_date
show_time
ticket_price
```

---

## Bookings Table

```
bookings
---------
booking_id PK
user_id FK
show_id FK
booking_date
total_amount
status
```

---

## Booking_Seats Table

```
booking_seats
--------------
booking_seat_id PK
booking_id FK
seat_id FK
```

---

# 10. Folder Structure

## React Frontend

```
BookMyShow-frontend

src
 ├── components
 │    ├── movies
 │    ├── booking
 │    ├── seats
 │    └── admin
 │
 ├── pages
 │    ├── Home
 │    ├── MovieDetails
 │    ├── SeatSelection
 │    ├── BookingSummary
 │    └── Dashboard
 │
 ├── services
 │    └── api.js
 │
 ├── context
 │    └── AuthContext.js
 │
 └── App.js
```

---

## Node.js Backend

```
BookMyShow-backend

src
 ├── controllers
 │    ├── authController.js
 │    ├── movieController.js
 │    ├── theatreController.js
 │    └── bookingController.js
 │
 ├── routes
 │    ├── authRoutes.js
 │    ├── movieRoutes.js
 │    └── bookingRoutes.js
 │
 ├── services
 │    ├── movieService.js
 │    └── bookingService.js
 │
 ├── models
 │    ├── User.js
 │    ├── Movie.js
 │    └── Booking.js
 │
 ├── middleware
 │    └── authMiddleware.js
 │
 ├── config
 │    └── db.js
 │
 └── server.js
```

---

# 11. Business Rules

The system follows these rules:

1. A seat cannot be booked twice for the same show.
2. Booking allowed only if seats are available.
3. Cancellation allowed before show start time.
4. Admin only can create shows.
5. Ticket pricing can vary per show.
6. Revenue calculated only for confirmed bookings.

---

# 12. Future Enhancements

The system can be extended with:

* Payment Gateway Integration
* SMS/Email notifications
* Real-time seat locking
* Mobile App
* Microservices architecture
* Cloud deployment
* Recommendation engine

---

# 13. Definition of Done

The project is complete when:

✔ React UI implemented
✔ Node.js REST APIs working
✔ Database integrated
✔ Seat booking implemented
✔ Admin panel functional
✔ Booking reports generated
✔ Complete project documentation submitted

---
