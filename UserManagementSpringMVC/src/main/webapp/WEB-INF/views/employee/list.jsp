<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>Employee Management</h2>
    <p class="mb-3">
        <a href="${pageContext.request.contextPath}/users" class="btn btn-outline-primary btn-sm">Users</a>
        <a href="${pageContext.request.contextPath}/employees" class="btn btn-primary btn-sm">Employees</a>
    </p>
    <a href="${pageContext.request.contextPath}/employees/create" class="btn btn-success mb-3">Add New Employee</a>

    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Employee Code</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Department</th>
            <th>Designation</th>
            <th>Join Date</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="emp" items="${employees}">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.employeeCode}</td>
                <td>${emp.email}</td>
                <td>${emp.phone != null ? emp.phone : '-'}</td>
                <td>${emp.department != null ? emp.department : '-'}</td>
                <td>${emp.designation != null ? emp.designation : '-'}</td>
                <td><fmt:formatDate value="${emp.joinDate}" pattern="yyyy-MM-dd"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/employees/view/${emp.id}" class="btn btn-info btn-sm">View</a>
                    <a href="${pageContext.request.contextPath}/employees/edit/${emp.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="${pageContext.request.contextPath}/employees/delete/${emp.id}" class="btn btn-danger btn-sm"
                       onclick="return confirm('Are you sure you want to delete this employee?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:if test="${empty employees}">
        <p class="text-muted">No employees found. Click "Add New Employee" to create one.</p>
    </c:if>
</div>
</body>
</html>
