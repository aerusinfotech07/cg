# SQL CREATE DATABASE Statement – Notes

## 1. What Does CREATE DATABASE Do?

The **CREATE DATABASE** statement creates a **new SQL database** on the server.

- You must have sufficient **privileges** (usually admin or CREATE permission) to create a database.
- After creation, you can create tables and other objects inside the database and connect applications to it.

---

## 2. Syntax

```sql
CREATE DATABASE databasename;
```

- **databasename** is the name you give the new database. Naming rules depend on the database system (often letters, digits, underscores; case sensitivity may apply).

---

## 3. Example

Create a database named **testDB**:

```sql
CREATE DATABASE testDB;
```

---

## 4. Tips

- **Privileges** — Ensure your user has permission to create databases (e.g. admin or `CREATE DATABASE` privilege) before running the statement.
- **Listing databases** — After creation, you can confirm the database exists:
  - **MySQL:** `SHOW DATABASES;`
  - **SQL Server:** Query the system catalog or use SSMS.
  - **PostgreSQL:** `\l` in psql or query `pg_database`.

---

## 5. Optional Clauses (Database-Dependent)

Some databases support extra options, for example:

- **Character set / collation** (e.g. MySQL):  
  `CREATE DATABASE testDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;`
- **If not exists** (e.g. MySQL):  
  `CREATE DATABASE IF NOT EXISTS testDB;`

Syntax and options vary by product; check your database documentation.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Create a database | `CREATE DATABASE databasename;` |
| Create if not exists (MySQL) | `CREATE DATABASE IF NOT EXISTS databasename;` |
| List databases (MySQL) | `SHOW DATABASES;` |

**Remember:** You need the right privileges to create a database. Use your system’s command or catalog to list databases after creation.
