# SQL RIGHT JOIN – Notes

## 1. What Is RIGHT JOIN?

The **RIGHT JOIN** returns:
- **All rows** from the **right** table (table2), and  
- **Only the matched rows** from the **left** table (table1).

If a row in the right table has **no match** in the left table, the columns from the left table appear as **NULL** in the result.

- **RIGHT JOIN** and **RIGHT OUTER JOIN** are the same; the **OUTER** keyword is optional.

---

## 2. Syntax

```sql
SELECT column_name(s)
FROM table1
RIGHT JOIN table2
ON table1.column_name = table2.column_name;
```

The **ON** clause defines how the two tables are linked (e.g. key = foreign key). The **right** table is the second one in the JOIN (table2).

---

## 3. Demo Database (selection)

**Orders**

| OrderID | CustomerID | EmployeeID | OrderDate   | ShipperID |
|---------|------------|------------|-------------|-----------|
| 10308   | 2          | 7          | 1996-09-18  | 3         |
| 10309   | 37         | 3          | 1996-09-19  | 1         |
| 10310   | 77         | 8          | 1996-09-20  | 2         |

**Employees**

| EmployeeID | LastName   | FirstName | BirthDate   | Photo     |
|------------|------------|-----------|-------------|-----------|
| 1          | Davolio    | Nancy     | 12/8/1968   | EmpID1.pic|
| 2          | Fuller     | Andrew    | 2/19/1952   | EmpID2.pic|
| 3          | Leverling  | Janet     | 8/30/1963   | EmpID3.pic|

---

## 4. RIGHT JOIN Example

Return **all employees** and any orders they might have placed. Employees with no orders still appear; order columns are NULL for them.

```sql
SELECT Orders.OrderID, Employees.LastName, Employees.FirstName
FROM Orders
RIGHT JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
ORDER BY Orders.OrderID;
```

- Every row from **Employees** (right table) appears.
- If an employee has orders, you get one row per order with OrderID and that employee’s name.
- If an employee has no orders, you get one row with **OrderID = NULL** and their name.

**Tip:** To list only employees who have **no** orders, add:  
`WHERE Orders.OrderID IS NULL`  
after the RIGHT JOIN.

---

## Quick Reference

| Goal | Example |
|------|---------|
| All right rows + matches from left (unmatched left = NULL) | `FROM t1 RIGHT JOIN t2 ON t1.col = t2.col` |
| Same as RIGHT JOIN | Use `RIGHT OUTER JOIN` |
| Only right rows with **no** match in left | Add `WHERE t1.column IS NULL` after the RIGHT JOIN |

**Remember:** RIGHT JOIN keeps **every** row from the **right** table; missing matches on the left show as NULL. In practice, the same result can often be written as a LEFT JOIN by swapping the table order.
