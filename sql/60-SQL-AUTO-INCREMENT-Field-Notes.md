# SQL AUTO INCREMENT Field – Notes

## 1. What Is Auto-Increment?

**Auto-increment** (or identity/sequence) lets the database **generate a unique value** automatically when a new row is inserted.

- It is commonly used for the **primary key** column so you do not have to supply the ID yourself.
- Syntax and behavior differ by database (MySQL, SQL Server, MS Access, Oracle).

---

## 2. MySQL: AUTO_INCREMENT

**CREATE TABLE** — mark the column as auto-increment and as primary key:

```sql
CREATE TABLE Persons (
    Personid int NOT NULL AUTO_INCREMENT,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    PRIMARY KEY (Personid)
);
```

- Default: starts at **1** and increments by **1** for each new row.

**Start from another value:**

```sql
ALTER TABLE Persons AUTO_INCREMENT = 100;
```

**INSERT** — omit the auto-increment column; the database assigns the next value:

```sql
INSERT INTO Persons (FirstName, LastName)
VALUES ('Lars', 'Monsen');
```

---

## 3. SQL Server: IDENTITY

**CREATE TABLE** — use **IDENTITY(start, increment)**:

```sql
CREATE TABLE Persons (
    Personid int IDENTITY(1,1) PRIMARY KEY,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int
);
```

- **IDENTITY(1,1)** — start at 1, increment by 1.  
- Example: **IDENTITY(10,5)** — start at 10, increment by 5.

**INSERT** — omit Personid; the database assigns the next value:

```sql
INSERT INTO Persons (FirstName, LastName)
VALUES ('Lars', 'Monsen');
```

---

## 4. MS Access: AUTOINCREMENT

**CREATE TABLE:**

```sql
CREATE TABLE Persons (
    Personid AUTOINCREMENT PRIMARY KEY,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int
);
```

- Default: start 1, increment 1.  
- Example: **AUTOINCREMENT(10,5)** — start at 10, increment by 5.

**INSERT** — omit Personid:

```sql
INSERT INTO Persons (FirstName, LastName)
VALUES ('Lars', 'Monsen');
```

---

## 5. Oracle: SEQUENCE

Oracle does not have a built-in “auto-increment” column type. Use a **SEQUENCE** and reference it in INSERT (or in a trigger/default).

**Create a sequence:**

```sql
CREATE SEQUENCE seq_person
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;
```

- **seq_person** — name of the sequence.  
- **CACHE 10** — preallocate values for performance (optional).

**CREATE TABLE** — Personid is a normal number column (no auto-increment in the column definition):

```sql
CREATE TABLE Persons (
    Personid int NOT NULL PRIMARY KEY,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int
);
```

**INSERT** — use **sequence_name.NEXTVAL** to get the next value:

```sql
INSERT INTO Persons (Personid, FirstName, LastName)
VALUES (seq_person.NEXTVAL, 'Lars', 'Monsen');
```

*(Alternatively, use a BEFORE INSERT trigger or a DEFAULT clause in Oracle 12c+ to set the column from the sequence so the application does not need to reference NEXTVAL.)*

---

## Quick Reference

| Database   | Create auto-increment column     | Set next value / start      | INSERT (omit ID) |
|-----------|-----------------------------------|-----------------------------|-------------------|
| **MySQL** | `col int NOT NULL AUTO_INCREMENT` + PRIMARY KEY | `ALTER TABLE t AUTO_INCREMENT=100;` | Omit column in INSERT |
| **SQL Server** | `col int IDENTITY(1,1) PRIMARY KEY` | Use IDENTITY(10,5) in CREATE | Omit column in INSERT |
| **MS Access** | `col AUTOINCREMENT PRIMARY KEY` | AUTOINCREMENT(10,5) in CREATE | Omit column in INSERT |
| **Oracle** | Normal column + SEQUENCE | CREATE SEQUENCE ... START WITH 100 | `INSERT ... VALUES (seq_name.NEXTVAL, ...)` |

**Remember:** Auto-increment generates a unique value for new rows; the exact keyword and syntax (AUTO_INCREMENT, IDENTITY, AUTOINCREMENT, SEQUENCE) depend on the database.
