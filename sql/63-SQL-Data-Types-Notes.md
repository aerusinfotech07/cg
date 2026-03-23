# SQL Data Types for MySQL, SQL Server, and MS Access – Notes

## 1. What Are Data Types?

The **data type** of a column defines what kind of value the column can hold: integer, character, money, date/time, binary, etc.

- Every column must have a **name** and a **data type**.
- When creating a table, the developer chooses the type so the database knows what to store and how to handle the data.

**Note:** Type names, sizes, and behavior can **differ between databases**. Always check your database’s documentation.

---

## 2. MySQL Data Types (8.0)

MySQL has three main categories: **string**, **numeric**, and **date and time**.

### String Data Types

| Data type | Description |
|-----------|-------------|
| **CHAR(size)** | Fixed-length string. size = 0–255 characters. Default 1. |
| **VARCHAR(size)** | Variable-length string. Max size 0–65535 characters. |
| **BINARY(size)** | Like CHAR but for binary byte strings. size in bytes. |
| **VARBINARY(size)** | Variable-length binary. size = max length in bytes. |
| **TINYBLOB** | Binary large object. Max 255 bytes. |
| **TINYTEXT** | String. Max 255 characters. |
| **TEXT(size)** | String. Max 65,535 bytes. |
| **BLOB(size)** | Binary. Max 65,535 bytes. |
| **MEDIUMTEXT** | String. Max 16,777,215 characters. |
| **MEDIUMBLOB** | Binary. Max 16,777,215 bytes. |
| **LONGTEXT** | String. Max 4,294,967,295 characters. |
| **LONGBLOB** | Binary. Max 4,294,967,295 bytes. |
| **ENUM(val1, val2, ...)** | One value from a list (up to 65535 values). |
| **SET(val1, val2, ...)** | Zero or more values from a list (up to 64 values). |

### Numeric Data Types

| Data type | Description |
|-----------|-------------|
| **BIT(size)** | Bit value. size 1–64. Default 1. |
| **TINYINT(size)** | Very small integer. Signed -128 to 127; unsigned 0 to 255. |
| **BOOL, BOOLEAN** | 0 = false, nonzero = true. |
| **SMALLINT(size)** | Small integer. Signed -32768 to 32767; unsigned 0 to 65535. |
| **MEDIUMINT(size)** | Medium integer. Signed about ±8.3e6; unsigned to 16777215. |
| **INT(size), INTEGER(size)** | Integer. Signed ±2.1e9; unsigned to 4294967295. |
| **BIGINT(size)** | Large integer. Signed ±9.2e18; unsigned to about 1.8e19. |
| **FLOAT(size, d)** | Floating point. (Deprecated in MySQL 8.0.17.) |
| **FLOAT(p)** | p 0–24 → FLOAT; p 25–53 → DOUBLE. |
| **DOUBLE(size, d)** | Double-precision float. |
| **DECIMAL(size, d), DEC(size, d)** | Exact fixed-point. size up to 65 digits; d decimal places (max 30). Default size 10, d 0. |

**Note:** Numeric types can use **UNSIGNED** (no negatives) or **ZEROFILL** (padding); ZEROFILL implies UNSIGNED.

### Date and Time Data Types

| Data type | Description |
|-----------|-------------|
| **DATE** | Date. YYYY-MM-DD. Range 1000-01-01 to 9999-12-31. |
| **DATETIME(fsp)** | Date and time. YYYY-MM-DD hh:mm:ss. Supports DEFAULT/ON UPDATE for current date/time. |
| **TIMESTAMP(fsp)** | Timestamp (seconds since Unix epoch). Range 1970-01-01 to 2038-01-09 UTC. |
| **TIME(fsp)** | Time. hh:mm:ss. |
| **YEAR** | Year, four-digit (e.g. 1901–2155). Two-digit not supported in 8.0. |

---

## 3. SQL Server Data Types

### String Data Types

| Data type | Description | Max length | Storage |
|-----------|-------------|------------|---------|
| **char(n)** | Fixed-length non-Unicode. n 1–8000. | 8,000 | n bytes |
| **varchar(n)** | Variable-length non-Unicode. n 1–8000. | 8,000 | n + 2 bytes |
| **varchar(max)** | Variable-length non-Unicode. | up to 2 GB | |
| **nchar(n)** | Fixed-length Unicode. n 1–4000. | 4,000 | 2×n bytes |
| **nvarchar(n)** | Variable-length Unicode. n 1–4000. | 4,000 | 2×n + 2 bytes |
| **nvarchar(max)** | Variable-length Unicode. | up to 2 GB | |
| **binary(n)** | Fixed-length binary. n 1–8000. | 8,000 | n bytes |
| **varbinary(n)** | Variable-length binary. n 1–8000. | 8,000 | length + 2 bytes |
| **varbinary(max)** | Variable-length binary. | 2 GB | |

### Numeric Data Types

| Data type | Description | Storage |
|-----------|-------------|---------|
| **bit** | 0, 1, or NULL. | |
| **tinyint** | 0 to 255. | 1 byte |
| **smallint** | -32,768 to 32,767. | 2 bytes |
| **int** | -2,147,483,648 to 2,147,483,647. | 4 bytes |
| **bigint** | Large integer range. | 8 bytes |
| **decimal(p,s), numeric(p,s)** | Fixed precision/scale. p 1–38 (total digits), s 0–p (decimal places). | 5–17 bytes |
| **smallmoney** | Monetary. About ±214,748.3648. | 4 bytes |
| **money** | Monetary. Large range. | 8 bytes |
| **float(n)** | Float. n 24 (4 bytes) or 53 (8 bytes). Default 53. | 4 or 8 bytes |
| **real** | Float. About ±3.40E+38. | 4 bytes |

### Date and Time Data Types

| Data type | Description | Storage |
|-----------|-------------|---------|
| **date** | Date only. 0001-01-01 to 9999-12-31. | 3 bytes |
| **time** | Time only. 100-nanosecond accuracy. | 3–5 bytes |
| **datetime** | Date and time. 1753–9999. 3.33 ms accuracy. | 8 bytes |
| **datetime2** | Date and time. 0001–9999. 100 ns accuracy. | 6–8 bytes |
| **smalldatetime** | Date and time. 1900–2079. 1 minute accuracy. | 4 bytes |
| **datetimeoffset** | Like datetime2 with time zone offset. | 8–10 bytes |
| **timestamp** | Unique number updated on row create/modify. Not a date/time display. | |

### Other Data Types

| Data type | Description |
|-----------|-------------|
| **sql_variant** | Up to 8,000 bytes of various types (except text, ntext, timestamp). |
| **uniqueidentifier** | GUID. |
| **xml** | XML. Max 2 GB. |
| **cursor** | Reference to a cursor. |
| **table** | Result set for later processing. |

---

## 4. MS Access Data Types

| Data type | Description | Storage |
|-----------|-------------|---------|
| **Text** | Text or text+numbers. Max 255 characters. | |
| **Memo** | Large text. Up to 65,536 characters. Not sortable; searchable. | |
| **Byte** | 0 to 255. | 1 byte |
| **Integer** | -32,768 to 32,767. | 2 bytes |
| **Long** | -2,147,483,648 to 2,147,483,647. | 4 bytes |
| **Single** | Single-precision float. | 4 bytes |
| **Double** | Double-precision float. | 8 bytes |
| **Currency** | Currency. 15 digits + 4 decimal places. | 8 bytes |
| **AutoNumber** | Auto-increment. Usually starts at 1. | 4 bytes |
| **Date/Time** | Date and time. | 8 bytes |
| **Yes/No** | Logical. Yes/No, True/False, On/Off. No NULL. | 1 bit |
| **Ole Object** | Pictures, audio, video, BLOBs. Up to 1 GB. | |
| **Hyperlink** | Links to files or web pages. | |
| **Lookup Wizard** | List of options (drop-down). | 4 bytes |

---

## Quick Reference

- **MySQL:** String (CHAR, VARCHAR, TEXT, BLOB, ENUM, SET), Numeric (INT, DECIMAL, FLOAT, etc.), Date/Time (DATE, DATETIME, TIMESTAMP, TIME, YEAR).
- **SQL Server:** String (char, varchar, nchar, nvarchar, binary, varbinary), Numeric (int, decimal, float, money), Date/Time (date, time, datetime, datetime2), plus sql_variant, uniqueidentifier, xml, etc.
- **MS Access:** Text, Memo, Byte, Integer, Long, Single, Double, Currency, AutoNumber, Date/Time, Yes/No, Ole Object, Hyperlink, Lookup Wizard.

**Remember:** Type names and limits differ by product. Always use your database’s documentation when choosing and defining data types.
