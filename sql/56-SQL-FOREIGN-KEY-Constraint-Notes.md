# SQL FOREIGN KEY Constraint – Notes

## 1. What Is the FOREIGN KEY Constraint?

The **FOREIGN KEY** constraint keeps **referential integrity** between two tables: it blocks actions that would break the link (e.g. inserting a value in the child that does not exist in the parent).

- A **foreign key** is a column (or set of columns) in one table that **references the PRIMARY KEY** (or a UNIQUE key) in another table.
- The table that **contains the foreign key** is often called the **child** table; the table being **referenced** is the **parent** (or referenced) table.
- Values in the foreign key column(s) must either exist in the parent’s key column(s) or be NULL (if the column allows NULL). The database rejects inserts or updates that violate this.

---

## 2. Example: Persons and Orders

**Persons** (parent — has primary key):

| PersonID | LastName | FirstName | Age |
|----------|----------|-----------|-----|
| 1 | Hansen | Ola | 30 |
| 2 | Svendson | Tove | 23 |
| 3 | Pettersen | Kari | 20 |

**Orders** (child — has foreign key):

| OrderID | OrderNumber | PersonID |
|---------|-------------|----------|
| 1 | 77895 | 3 |
| 2 | 44678 | 3 |
| 3 | 22456 | 2 |
| 4 | 24562 | 1 |

- **PersonID** in **Persons** is the **PRIMARY KEY**.
- **PersonID** in **Orders** is a **FOREIGN KEY** that **references Persons(PersonID)**.

The FOREIGN KEY constraint ensures that every **PersonID** in Orders exists in Persons, so you cannot insert an order with a non‑existent PersonID.

---

## 3. FOREIGN KEY on CREATE TABLE

**MySQL:**

```sql
CREATE TABLE Orders (
    OrderID int NOT NULL,
    OrderNumber int NOT NULL,
    PersonID int,
    PRIMARY KEY (OrderID),
    FOREIGN KEY (PersonID) REFERENCES Persons(PersonID)
);
```

**SQL Server / Oracle / MS Access:**

```sql
CREATE TABLE Orders (
    OrderID int NOT NULL PRIMARY KEY,
    OrderNumber int NOT NULL,
    PersonID int FOREIGN KEY REFERENCES Persons(PersonID)
);
```

**Named foreign key** (MySQL / SQL Server / Oracle / MS Access):

```sql
CREATE TABLE Orders (
    OrderID int NOT NULL,
    OrderNumber int NOT NULL,
    PersonID int,
    PRIMARY KEY (OrderID),
    CONSTRAINT FK_PersonOrder FOREIGN KEY (PersonID)
    REFERENCES Persons(PersonID)
);
```

- **FK_PersonOrder** is the constraint name. For a **composite** foreign key, list multiple columns: `FOREIGN KEY (col1, col2) REFERENCES Parent(col1, col2)`.

---

## 4. FOREIGN KEY on ALTER TABLE

Add a foreign key to an **existing** table.

**Unnamed:**

```sql
ALTER TABLE Orders
ADD FOREIGN KEY (PersonID) REFERENCES Persons(PersonID);
```

**Named:**

```sql
ALTER TABLE Orders
ADD CONSTRAINT FK_PersonOrder
FOREIGN KEY (PersonID) REFERENCES Persons(PersonID);
```

**Note:** Existing data in the foreign key column must satisfy the constraint (each value must exist in the parent, or be NULL if allowed), or the ADD will fail.

---

## 5. Drop a FOREIGN KEY Constraint

**MySQL:**

```sql
ALTER TABLE Orders
DROP FOREIGN KEY FK_PersonOrder;
```

**SQL Server / Oracle / MS Access:**

```sql
ALTER TABLE Orders
DROP CONSTRAINT FK_PersonOrder;
```

Use the actual constraint name (the one you gave or the one the database generated).

---

## Quick Reference

| Goal | Example |
|------|---------|
| FK on CREATE (MySQL) | `FOREIGN KEY (PersonID) REFERENCES Persons(PersonID)` |
| FK on CREATE (SQL Server, etc.) | `PersonID int FOREIGN KEY REFERENCES Persons(PersonID)` |
| Named FK | `CONSTRAINT FK_PersonOrder FOREIGN KEY (PersonID) REFERENCES Persons(PersonID)` |
| Add FK (ALTER) | `ALTER TABLE t ADD FOREIGN KEY (col) REFERENCES parent(col);` or `ADD CONSTRAINT name ...` |
| Drop FK (MySQL) | `ALTER TABLE t DROP FOREIGN KEY constraint_name;` |
| Drop FK (SQL Server, etc.) | `ALTER TABLE t DROP CONSTRAINT constraint_name;` |

**Remember:** The foreign key column(s) reference the parent’s primary (or unique) key; the database rejects values that do not exist in the parent (unless NULL is allowed).
