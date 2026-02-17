<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Management - List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1>User Management (JSP)</h1>
    <c:if test="${not empty message}">
        <div class="alert alert-success">${message}</div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>
    <p>
        <a href="<c:url value='/users/new'/>" class="btn btn-primary">Add New User</a>
    </p>
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Username</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.username}</td>
                <td>${u.email}</td>
                <td>${u.phone}</td>
                <td>
                    <a href="<c:url value='/users/${u.id}'/>" class="btn btn-sm btn-info">View</a>
                    <a href="<c:url value='/users/${u.id}/edit'/>" class="btn btn-sm btn-warning">Edit</a>
                    <form action="<c:url value='/users/${u.id}/delete'/>" method="post" style="display:inline;">
                        <button type="submit" class="btn btn-sm btn-danger" onclick="return confirm('Delete this user?');">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
