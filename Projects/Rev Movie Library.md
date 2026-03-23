Core Functional Requirements

As a Library Member, I should be able to:



**Register and create an account with personal details**



Login to my account



Browse movies by categories (genre, language, year, rating)



Search movies using filters (title, genre, actor, director, release year, rating)



View detailed movie information (cast, crew, duration, synopsis, ratings, availability)



Add movies to my watchlist



Borrow available movies (subject to borrowing limits)



Return borrowed movies



View my borrowing history with due dates and status (Borrowed/Returned/Overdue)



Rate and review movies



Receive in-app notifications for due date reminders and new movie additions



Update and manage profile information



As an Administrator, I should be able to:



**Register and login using admin credentials**



Add new movies with complete details (title, genre, director, cast, language, duration, release year, rating, stock quantity)



Update movie details



Delete movies from the library



Manage movie categories and genres



View all registered members



Block/unblock members



Monitor borrowing activities and overdue returns



Generate reports (most borrowed movies, active members, overdue records)



Manage system notifications



**Standard Functional Scope**

**Authentication \& Account Management**



Register (separate flows for Members and Administrators)



Login using email and password



Change password (requires current password)



Forgotten password recovery through security questions



Profile completion tracking



**Movie Management Module**



Add, update, delete movies



Categorize movies (Genre, Language, Year, Rating)



Manage stock availability



Search and filtering functionality



Borrowing \& Return Module



Borrow movie (check availability)



Return movie (calculate overdue if applicable)



View borrowing history



Due date tracking



**Review \& Rating Module**



Add movie rating (1–5 scale)



Write textual reviews



View average ratings



Notification System



In-app notifications for:



Due date reminders



Overdue alerts



New movie additions



Account status changes



High-Level Architecture



The application follows a layered modular architecture:



Presentation Layer (Console UI)

&nbsp;       ↓

Service Layer (Business Logic)

&nbsp;       ↓

Repository/Data Access Layer

&nbsp;       ↓

Database Layer



Modules:



Authentication Module



User Management Module



Movie Management Module



Borrowing Management Module



Review \& Rating Module



Notification Module



This design enables future migration to:



REST APIs



Web Frontend (React/Angular)



Microservices Architecture



Cloud Deployment



&nbsp;ERD (Entity Relationship Diagram – Conceptual)

Key Entities:



User



user\_id (PK)



name



email



password



role (Member/Admin)



status



Movie



movie\_id (PK)



title



genre



director



release\_year



language



rating



stock\_quantity



Borrow



borrow\_id (PK)



user\_id (FK)



movie\_id (FK)



borrow\_date



due\_date



return\_date



status



Review



review\_id (PK)



user\_id (FK)



movie\_id (FK)



rating



comment



review\_date



Notification



notification\_id (PK)



user\_id (FK)



message



status



created\_date



Application Architecture Diagram (Logical View)

+---------------------------+

|      Console UI Layer     |

+---------------------------+

&nbsp;           ↓

+---------------------------+

|    Controller Layer       |

+---------------------------+

&nbsp;           ↓

+---------------------------+

|     Service Layer         |

|  - User Service           |

|  - Movie Service          |

|  - Borrow Service         |

|  - Review Service         |

+---------------------------+

&nbsp;           ↓

+---------------------------+

| Repository/Data Layer     |

+---------------------------+

&nbsp;           ↓

+---------------------------+

|        Database           |

+---------------------------+

&nbsp;Definition of Done



&nbsp;Working Console Application Demonstration

&nbsp;User and Admin role-based access implemented

&nbsp;CRUD operations for movies

&nbsp;Borrow/Return workflow implemented

&nbsp;Search \& Filter functionality implemented

&nbsp;Ratings \& Reviews functionality

&nbsp;Notification system working

&nbsp;Code Repository Submission including:

ERD Diagram



Application Architecture Diagram



Clean folder structure



README documentation

