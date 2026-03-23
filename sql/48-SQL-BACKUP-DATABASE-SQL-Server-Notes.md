# SQL BACKUP DATABASE for SQL Server – Notes

## 1. What Is BACKUP DATABASE?

The **BACKUP DATABASE** statement is used in **SQL Server** to create a backup of an existing SQL database.

- A **full** backup copies the entire database to a file (e.g. `.bak`).
- A **differential** backup copies only the data that has **changed since the last full** backup, which is faster and uses less space when used in combination with full backups.

---

## 2. Full Backup Syntax

```sql
BACKUP DATABASE databasename
TO DISK = 'filepath';
```

- **databasename** — name of the database to back up.
- **filepath** — full path and filename where the backup will be written (e.g. `'D:\backups\testDB.bak'`).

---

## 3. Differential Backup Syntax

A **differential** backup backs up only the parts of the database that have changed since the **last full** database backup.

```sql
BACKUP DATABASE databasename
TO DISK = 'filepath'
WITH DIFFERENTIAL;
```

- You must have at least one **full** backup before differential backups are useful. Restore typically uses the last full backup plus the latest differential.

---

## 4. Full Backup Example

Create a **full** backup of the database **testDB** to the D: drive:

```sql
BACKUP DATABASE testDB
TO DISK = 'D:\backups\testDB.bak';
```

**Tip:** Store backups on a **different drive** (or device) than the one holding the live database. If the database disk fails, the backup file is still available.

---

## 5. Differential Backup Example

Create a **differential** backup of **testDB**:

```sql
BACKUP DATABASE testDB
TO DISK = 'D:\backups\testDB.bak'
WITH DIFFERENTIAL;
```

**Tip:** Differential backups are **faster and smaller** than full backups because they only include changes since the last full backup. Use them between full backups to reduce backup time and storage.

---

## 6. Database-Specific Note

**BACKUP DATABASE** and **BACKUP ... WITH DIFFERENTIAL** are **SQL Server** (T-SQL) syntax. Other systems use different tools:

- **MySQL** — `mysqldump`, or enterprise backup tools.
- **PostgreSQL** — `pg_dump`, `pg_basebackup`, or third-party tools.
- **Oracle** — RMAN or other backup utilities.

---

## Quick Reference

| Goal | Example (SQL Server) |
|------|----------------------|
| Full backup | `BACKUP DATABASE testDB TO DISK = 'D:\backups\testDB.bak';` |
| Differential backup | `BACKUP DATABASE testDB TO DISK = 'D:\backups\testDB.bak' WITH DIFFERENTIAL;` |

**Remember:** Full backup = entire database; differential = only changes since last full. Keep backups on a different drive from the database when possible.
