# SQL DROP DATABASE Statement – Notes

## 1. What Does DROP DATABASE Do?

The **DROP DATABASE** statement **removes an existing SQL database** from the server.

- The database and **all** its contents (tables, data, views, procedures, etc.) are **permanently deleted**.
- This action **cannot be undone**; all information stored in the database is lost.

---

## 2. Syntax

```sql
DROP DATABASE databasename;
```

- **databasename** is the name of the database you want to drop.

---

## 3. Warning

**Use DROP DATABASE with care.** Deleting a database removes **all** data and objects in it. Ensure you have a backup or no longer need the database before running the statement.

---

## 4. Example

Drop the database named **testDB**:

```sql
DROP DATABASE testDB;
```

---

## 5. Tips

- **Privileges** — You need sufficient privileges (typically admin or DROP permission) to drop a database.
- **Verify** — After dropping, you can confirm the database is gone (e.g. in **MySQL**: `SHOW DATABASES;`).
- **In use** — Some databases do not allow dropping a database that is currently in use; you may need to disconnect sessions or switch to another database first.

---

## 6. Optional Clauses (Database-Dependent)

- **MySQL:** `DROP DATABASE IF EXISTS databasename;` — avoids an error if the database does not exist.
- **SQL Server:** `DROP DATABASE databasename;` — may require putting the database in a single-user or offline state first if it is in use.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Drop a database | `DROP DATABASE databasename;` |
| Drop if exists (MySQL) | `DROP DATABASE IF EXISTS databasename;` |

**Remember:** DROP DATABASE permanently deletes the database and all its data. Always confirm before running it.
