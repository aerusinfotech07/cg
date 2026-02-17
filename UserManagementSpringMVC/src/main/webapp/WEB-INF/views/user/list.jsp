<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Management</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>User Management</h2>
    <p class="mb-3">
        <a href="${pageContext.request.contextPath}/users" class="btn btn-primary btn-sm">Users</a>
        <a href="${pageContext.request.contextPath}/employees" class="btn btn-outline-primary btn-sm">Employees</a>
    </p>
    <a href="${pageContext.request.contextPath}/users/create" class="btn btn-primary mb-3">Add New User</a>

    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Username</th>
            <th>Email</th>
            <th>Phone</th>
            <th>City</th>
            <th>Company</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.phone != null ? user.phone : '-'}</td>
                <td>${user.address != null && user.address.city != null ? user.address.city : '-'}</td>
                <td>${user.company != null && user.company.name != null ? user.company.name : '-'}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/users/view/${user.id}" class="btn btn-info btn-sm">View</a>
                    <a href="${pageContext.request.contextPath}/users/edit/${user.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="${pageContext.request.contextPath}/users/delete/${user.id}" class="btn btn-danger btn-sm"
                       onclick="return confirm('Are you sure you want to delete this user?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:if test="${empty users}">
        <p class="text-muted">No users found. Click "Add New User" to create one.</p>
    </c:if>
</div>
</body>
</html>
