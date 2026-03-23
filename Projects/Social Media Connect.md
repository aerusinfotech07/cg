Below is a **professional project document for SocialMedia Social Media Application** using **React (UI) + Node.js (Backend) + MySQL/MongoDB**.



---

# SocialMedia

## Social Media Networking Platform

### Software Requirement & Design Document

---

# 1. Project Overview

**SocialMedia** is a social networking platform that allows users to connect, share content, interact through posts, likes, comments, and build their personal or professional network.

The application supports multiple types of users:

* **Personal Users**
* **Creator Accounts**
* **Business Accounts**

Users can create posts, interact with other users' content, follow accounts, build connections, and receive notifications.

The system is designed using **modern full-stack architecture** with:

Frontend: **React.js**
Backend: **Node.js (Express.js)**
Database: **MySQL / MongoDB**

The architecture is modular and scalable, enabling future expansion into:

* Microservices
* Mobile apps
* Real-time chat systems
* Cloud deployment

---

# 2. Technology Stack

## Frontend

| Technology              | Purpose          |
| ----------------------- | ---------------- |
| React.js                | UI Development   |
| React Router            | Navigation       |
| Axios                   | API requests     |
| Material UI / Bootstrap | UI Components    |
| Redux / Context API     | State management |

---

## Backend

| Technology | Purpose             |
| ---------- | ------------------- |
| Node.js    | Server runtime      |
| Express.js | REST API framework  |
| JWT        | Authentication      |
| bcrypt     | Password encryption |
| multer     | File upload         |
| Nodemailer | Email notifications |

---

## Database

Option 1: **MySQL (Relational Database)**
Option 2: **MongoDB (NoSQL Database)**

---

# 3. System Architecture

```
                 +-----------------------+
                 |      React UI         |
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
                 |       Database        |
                 |    MySQL / MongoDB    |
                 +-----------------------+
```

---

# 4. User Types

The application supports **three user types**.

### 1. Personal Users

Individuals who interact socially on the platform.

### 2. Creator Accounts

Content creators who build followers and post media content.

### 3. Business Accounts

Companies promoting products or services.

---

# 5. Core Modules

The system contains the following modules:

1. Authentication Module
2. User Profile Module
3. Post Management Module
4. Social Interaction Module
5. Network / Connection Module
6. Notification Module
7. Feed & Discovery Module
8. Messaging Module (Optional)
9. Analytics Module (Creators/Business)

---

# 6. UI Design (React)

## Main Layout

```
Navbar
Sidebar
Feed
RightPanel
Footer
```

---

# 7. Personal User Interface

## Home / Feed Page

Displays:

* Posts from connections
* Posts from followed users
* User posts

Components:

```
FeedPage
PostCard
CreatePost
TrendingTags
```

---

## Profile Page

Displays:

* Profile picture
* Bio
* Followers
* Following
* Posts

Components:

```
ProfilePage
ProfileHeader
ProfilePosts
ConnectionsList
```

---

## Post Creation Page

Users can:

* Write text posts
* Add hashtags
* Attach media (future)

Component:

```
CreatePost
```

---

## Post Interaction

Users can:

* Like posts
* Comment on posts
* Share posts

Components:

```
LikeButton
CommentSection
ShareButton
```

---

# 8. Creator / Business Dashboard UI

Creators and businesses get **enhanced features**.

Dashboard includes:

* Post analytics
* Followers insights
* Business information
* Promotional content

Components:

```
CreatorDashboard
PostAnalytics
FollowerInsights
PromotionalPosts
```

---

# 9. Backend API Design (Node.js)

Base URL:

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

# User APIs

| Method | API              | Description       |
| ------ | ---------------- | ----------------- |
| GET    | /users/:id       | View user profile |
| PUT    | /users/:id       | Update profile    |
| GET    | /users/search    | Search users      |
| GET    | /users/followers | Followers list    |

---

# Post APIs

| Method | API        | Description  |
| ------ | ---------- | ------------ |
| POST   | /posts     | Create post  |
| GET    | /posts     | Get feed     |
| GET    | /posts/:id | Post details |
| PUT    | /posts/:id | Edit post    |
| DELETE | /posts/:id | Delete post  |

---

# Interaction APIs

| Method | API                | Description    |
| ------ | ------------------ | -------------- |
| POST   | /posts/:id/like    | Like post      |
| DELETE | /posts/:id/like    | Unlike post    |
| POST   | /posts/:id/comment | Add comment    |
| DELETE | /comments/:id      | Delete comment |

---

# Connection APIs

| Method | API                  | Description       |
| ------ | -------------------- | ----------------- |
| POST   | /connections/request | Send request      |
| POST   | /connections/accept  | Accept request    |
| POST   | /connections/reject  | Reject request    |
| DELETE | /connections/remove  | Remove connection |

---

# Follow APIs

| Method | API         | Description      |
| ------ | ----------- | ---------------- |
| POST   | /follow/:id | Follow account   |
| DELETE | /follow/:id | Unfollow account |

---

# Notification APIs

| Method | API                 | Description       |
| ------ | ------------------- | ----------------- |
| GET    | /notifications      | Get notifications |
| PUT    | /notifications/read | Mark as read      |

---

# 10. Database Design (MySQL)

## Users Table

```
users
------
user_id PK
name
email
username
password
account_type
bio
profile_picture
location
website
created_at
```

---

## Posts Table

```
posts
------
post_id PK
user_id FK
content
hashtags
created_at
updated_at
```

---

## Likes Table

```
likes
------
like_id PK
user_id FK
post_id FK
created_at
```

---

## Comments Table

```
comments
---------
comment_id PK
post_id FK
user_id FK
comment_text
created_at
```

---

## Connections Table

```
connections
------------
connection_id PK
user_id FK
connected_user_id FK
status
created_at
```

---

## Followers Table

```
followers
---------
follower_id PK
user_id FK
follower_user_id FK
```

---

## Notifications Table

```
notifications
-------------
notification_id PK
user_id FK
type
message
status
created_at
```

---

# 11. Folder Structure

## React Frontend

```
SocialMedia-frontend

src
 ├── components
 │    ├── posts
 │    ├── comments
 │    ├── notifications
 │    └── profile
 │
 ├── pages
 │    ├── Feed
 │    ├── Profile
 │    ├── Login
 │    ├── Register
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
SocialMedia-backend

src
 ├── controllers
 │    ├── authController.js
 │    ├── postController.js
 │    ├── userController.js
 │
 ├── routes
 │    ├── authRoutes.js
 │    ├── postRoutes.js
 │    ├── userRoutes.js
 │
 ├── models
 │    ├── User.js
 │    ├── Post.js
 │    ├── Comment.js
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

* Connection request received
* Connection accepted
* New follower
* Post liked
* Comment received
* Post shared
* New post from followed accounts

Each notification includes:

```
notification_id
user_id
type
message
status
created_date
```

---

# 13. Optional Feature: Messaging System

Future module:

Direct Messaging

Features:

* Send private messages
* View message history
* Mark message read/unread
* Delete conversations
* Block users

Tables:

```
messages
---------
message_id
sender_id
receiver_id
message_text
created_at
status
```

---

# 14. Business Rules

The system follows these rules:

1. Users must register before posting.
2. Only the post owner can edit/delete posts.
3. Users can delete only their own comments.
4. Private profiles restrict content visibility.
5. Followers can see posts from public accounts.
6. Notifications are generated for all interactions.

---

# 15. Future Enhancements

The system can be extended with:

* Mobile application
* Real-time notifications
* Live chat messaging
* AI content recommendations
* Video uploads
* Story feature
* Advertisement system
* Microservices architecture
* Cloud deployment

---

# 16. Definition of Done

The project is complete when:

✔ React UI implemented
✔ Node.js backend APIs working
✔ Database integrated
✔ User registration and login implemented
✔ Post creation and feed working
✔ Like/comment system implemented
✔ Follow/connection system implemented
✔ Notifications working
✔ Code repository submitted with:



