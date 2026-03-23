Below is the **same professional full-stack documentation format** for **RevHire – Job Portal Application** using **React (UI) + Node.js (Backend) + MySQL/MongoDB**.

This format is suitable for:

* **MCA / Final Year Project**
* **Full Stack Training Project**
* **Software Requirement Specification (SRS)**
* **GitHub Documentation**

---

# RevHire

## Job Portal Application

### Software Requirement & Design Document

---

# 1. Project Overview

**RevHire** is a job portal platform that connects **job seekers and employers**. The system allows job seekers to build profiles, create resumes, search for jobs, and apply for job openings. Employers can post job openings, manage job postings, review applicants, and shortlist or reject candidates.

The system supports two major user roles:

* **Job Seekers**
* **Employers**

The platform is designed with a **modern full-stack architecture** using:

Frontend: **React.js**
Backend: **Node.js (Express.js)**
Database: **MySQL / MongoDB**

The architecture is modular and scalable, allowing future extension into:

* Microservices architecture
* Mobile applications
* AI-based job recommendations
* Cloud deployment

---

# 2. Technology Stack

## Frontend

| Technology              | Purpose           |
| ----------------------- | ----------------- |
| React.js                | UI Development    |
| React Router            | Navigation        |
| Axios                   | API communication |
| Material UI / Bootstrap | UI components     |
| Redux / Context API     | State management  |

---

## Backend

| Technology | Purpose                     |
| ---------- | --------------------------- |
| Node.js    | Server runtime              |
| Express.js | REST API framework          |
| JWT        | Authentication              |
| bcrypt     | Password encryption         |
| multer     | Resume file upload (future) |
| Nodemailer | Email notifications         |

---

## Database

Option 1: **MySQL (Relational Database)**
Option 2: **MongoDB (NoSQL Database)**

---

# 3. System Architecture

```
               +-----------------------+
               |       React UI        |
               |   (Frontend Layer)    |
               +-----------------------+
                         |
                         | REST APIs
                         ↓
               +-----------------------+
               |     Node.js Backend   |
               |      Express API      |
               +-----------------------+
                         |
                         ↓
               +-----------------------+
               |        Database       |
               |     MySQL/MongoDB     |
               +-----------------------+
```

---

# 4. User Roles

The system supports two primary user roles.

---

## Job Seeker

Job seekers are individuals searching for job opportunities.

They can:

* Register and login
* Create and manage resumes
* Search jobs
* Apply for jobs
* Track application status
* Manage profiles

---

## Employer

Employers represent companies offering jobs.

They can:

* Register company accounts
* Create job postings
* Manage job postings
* View applicants
* Shortlist or reject candidates

---

# 5. Core Modules

The system is divided into the following modules:

1. Authentication Module
2. Job Seeker Profile Module
3. Resume Management Module
4. Job Posting Module
5. Job Application Module
6. Employer Management Module
7. Notification Module
8. Reporting & Analytics Module

---

# 6. UI Design (React)

## Main Layout

```
Navbar
Sidebar
Content Area
Footer
```

---

# 7. Job Seeker Interface

## Job Seeker Dashboard

Displays:

* Recommended jobs
* Recent applications
* Job alerts

Components:

```
JobSeekerDashboard
RecommendedJobs
RecentApplications
JobAlerts
```

---

## Resume Builder Page

Allows users to create structured resume sections:

* Objective
* Education
* Experience
* Skills
* Projects
* Certifications

Components:

```
ResumeBuilder
EducationSection
ExperienceSection
SkillsSection
ProjectsSection
```

---

## Job Search Page

Allows users to search jobs using filters.

Filters include:

* Job role
* Location
* Company name
* Experience level
* Salary range
* Job type

Components:

```
JobSearch
JobFilter
JobList
JobCard
```

---

## Job Application Page

Users can apply to jobs.

Displays:

* Job details
* Resume preview
* Optional cover letter

Components:

```
JobDetails
ApplyJobForm
ApplicationStatus
```

---

## Application History Page

Users can track job applications.

Displays:

* Job applied
* Application date
* Application status

Components:

```
ApplicationHistory
ApplicationCard
WithdrawApplication
```

---

# 8. Employer Interface

## Employer Dashboard

Displays:

* Active job postings
* Recent applications
* Hiring analytics

Components:

```
EmployerDashboard
JobPostingSummary
ApplicantStats
```

---

## Job Posting Management

Employers can:

* Create job postings
* Edit job postings
* Close or reopen jobs
* Delete job postings

Components:

```
JobPostingForm
JobPostingList
EditJobPosting
```

---

## Applicant Management

Employers can:

* View applicants
* Filter applicants
* Shortlist candidates
* Reject candidates

Components:

```
ApplicantList
ApplicantProfile
ShortlistAction
RejectAction
```

---

# 9. Backend API Design (Node.js)

Base API URL:

```
/api
```

---

# Authentication APIs

| Method | API                   | Description       |
| ------ | --------------------- | ----------------- |
| POST   | /auth/register        | Register user     |
| POST   | /auth/login           | Login             |
| POST   | /auth/change-password | Change password   |
| POST   | /auth/forgot-password | Password recovery |

---

# Job APIs

| Method | API       | Description        |
| ------ | --------- | ------------------ |
| GET    | /jobs     | Get all jobs       |
| GET    | /jobs/:id | Job details        |
| POST   | /jobs     | Create job posting |
| PUT    | /jobs/:id | Update job         |
| DELETE | /jobs/:id | Delete job         |

---

# Resume APIs

| Method | API     | Description   |
| ------ | ------- | ------------- |
| GET    | /resume | Get resume    |
| POST   | /resume | Create resume |
| PUT    | /resume | Update resume |

---

# Application APIs

| Method | API                        | Description           |
| ------ | -------------------------- | --------------------- |
| POST   | /applications              | Apply for job         |
| GET    | /applications/user         | Get user applications |
| PUT    | /applications/:id/withdraw | Withdraw application  |

---

# Employer APIs

| Method | API                         | Description         |
| ------ | --------------------------- | ------------------- |
| GET    | /employers/jobs             | Employer job list   |
| GET    | /employers/applicants       | View applicants     |
| PUT    | /applications/:id/shortlist | Shortlist candidate |
| PUT    | /applications/:id/reject    | Reject candidate    |

---

# Notification APIs

| Method | API                 | Description                |
| ------ | ------------------- | -------------------------- |
| GET    | /notifications      | Get notifications          |
| PUT    | /notifications/read | Mark notifications as read |

---

# 10. Database Design (MySQL)

## Users Table

```
users
------
user_id PK
name
email
password
role (jobseeker/employer)
created_at
```

---

## Job Seekers Table

```
job_seekers
-----------
job_seeker_id PK
user_id FK
education
experience
skills
certifications
```

---

## Employers Table

```
employers
---------
employer_id PK
user_id FK
company_name
industry
company_size
description
website
location
```

---

## Jobs Table

```
jobs
-----
job_id PK
employer_id FK
title
description
skills_required
experience_required
education_required
location
salary_range
job_type
deadline
status
```

---

## Applications Table

```
applications
------------
application_id PK
job_id FK
job_seeker_id FK
application_date
status
cover_letter
```

Application Status:

```
Applied
Shortlisted
Rejected
Withdrawn
```

---

## Resume Table

```
resumes
-------
resume_id PK
job_seeker_id FK
objective
education
experience
skills
projects
```

---

## Notifications Table

```
notifications
-------------
notification_id PK
user_id FK
message
status
created_date
```

---

# 11. Folder Structure

## React Frontend

```
revhire-frontend

src
 ├── components
 │    ├── jobs
 │    ├── resume
 │    ├── applications
 │    └── notifications
 │
 ├── pages
 │    ├── Dashboard
 │    ├── JobSearch
 │    ├── ResumeBuilder
 │    ├── EmployerDashboard
 │    └── Applications
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
revhire-backend

src
 ├── controllers
 │    ├── authController.js
 │    ├── jobController.js
 │    ├── applicationController.js
 │
 ├── routes
 │    ├── authRoutes.js
 │    ├── jobRoutes.js
 │    ├── applicationRoutes.js
 │
 ├── models
 │    ├── User.js
 │    ├── Job.js
 │    ├── Application.js
 │
 ├── middleware
 │    └── authMiddleware.js
 │
 ├── services
 │    └── notificationService.js
 │
 ├── config
 │    └── db.js
 │
 └── server.js
```

---

# 12. Notification System

Notifications include:

* Application submitted
* Application shortlisted
* Application rejected
* Job match alerts
* New applications for employers

Notification structure:

```
notification_id
user_id
message
status
created_date
```

---

# 13. Business Rules

The system follows these rules:

1. Only registered users can apply for jobs.
2. Each job application must belong to a valid job seeker and job.
3. Employers can manage only their own job postings.
4. Job seekers can withdraw only their own applications.
5. Application status updates trigger notifications.
6. Jobs automatically close after the deadline.

---

# 14. Future Enhancements

The system can be extended with:

* Resume file uploads (PDF)
* AI-based job recommendations
* Interview scheduling
* Real-time chat between employer and candidate
* Video interview integration
* Mobile application
* Cloud deployment
* Microservices architecture

---

# 15. Definition of Done

The project is considered complete when:

✔ React UI implemented
✔ Node.js backend APIs working
✔ Database integrated
✔ Job posting and job search implemented
✔ Resume builder implemented
✔ Job application workflow implemented
✔ Application tracking implemented
✔ Notifications working
✔ Code repository submitted
